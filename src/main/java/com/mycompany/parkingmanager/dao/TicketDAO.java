/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingmanager.dao;

import com.mycompany.parkingmanager.model.Ticket;
import com.mycompany.parkingmanager.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Vu
 */
public class TicketDAO {
    
    public void insertTicketWithVehicleTypeName(Ticket ticket, String vehicleTypeName) {
        String findVehicleTypeId = "SELECT id FROM vehicle_type WHERE name = ?";
        String insertTicket = "INSERT INTO ticket (ticket_code, license_plate, vehicle_type_id, entry_time, is_active) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            // Lấy ID của loại xe từ tên
            int vehicleTypeId = -1;
            try (PreparedStatement ps1 = conn.prepareStatement(findVehicleTypeId)) {
                ps1.setString(1, vehicleTypeName);
                ResultSet rs = ps1.executeQuery();
                if (rs.next()) {
                    vehicleTypeId = rs.getInt("id");
                } else {
                    throw new RuntimeException("Vehicle type not found: " + vehicleTypeName);
                }
            }

            // Chèn ticket
            try (PreparedStatement ps2 = conn.prepareStatement(insertTicket)) {
                ps2.setString(1, ticket.getTicketCode());
                ps2.setString(2, ticket.getLicensePlate());
                ps2.setInt(3, vehicleTypeId);
                ps2.setTimestamp(4, Timestamp.valueOf(ticket.getEntryTime()));
                ps2.setBoolean(5, true);
                ps2.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Tính số chỗ còn lại = tổng slot - số vé active
    public int getRemainingSlots() {
        int total = 0;
        int active = 0;

        try (Connection conn = DBConnection.getConnection()) {
            // Tổng số chỗ
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT SUM(total_slots) AS total FROM parking_info")) {
                if (rs.next()) total = rs.getInt("total");
            }

            // Số vé active
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT COUNT(*) AS active FROM ticket WHERE is_active = TRUE")) {
                if (rs.next()) active = rs.getInt("active");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return total - active;
    }
    
    // Lấy hết tất cả vé kèm theo xe
    public List<Ticket> getAllTicketsWithVehicleTypeName() throws SQLException {
    List<Ticket> list = new ArrayList<>();
    String sql = "SELECT t.*, v.name AS vehicle_type_name " +
                 "FROM ticket t " +
                 "JOIN vehicle_type v ON t.vehicle_type_id = v.id";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setTicketCode(rs.getString("ticket_code"));
                ticket.setLicensePlate(rs.getString("license_plate"));
                ticket.setVehicleTypeId(rs.getInt("vehicle_type_id"));
                ticket.setVehicleTypeName(rs.getString("vehicle_type_name")); // ✅ Tên loại xe
                ticket.setEntryTime(rs.getTimestamp("entry_time").toLocalDateTime());
                ticket.setExitTime(rs.getTimestamp("exit_time").toLocalDateTime());
                ticket.setActive(rs.getBoolean("is_active"));
                list.add(ticket);
            }
        }
        return list;
    }

    // Cập nhật vé khi xe ra
    public void exitTicket(String ticketCode) {
    String sql = "UPDATE ticket SET exit_time = ?, is_active = FALSE WHERE ticket_code = ? AND is_active = TRUE";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
        ps.setString(2, ticketCode);
        int updated = ps.executeUpdate();

        if (updated == 0) {
            System.out.println("Không tìm thấy vé đang hoạt động với mã: " + ticketCode);
        } else {
            System.out.println("Đã cập nhật thông tin khi xe rời bến cho mã vé: " + ticketCode);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    // Tìm theo ticket code
    public Ticket findByTicketCode(String code) {
        String sql = "SELECT * FROM ticket WHERE ticket_code = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return extractTicket(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Tìm kiếm theo ngày
    public List<Ticket> findByDateRange(LocalDateTime from, LocalDateTime to) {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM ticket WHERE entry_time BETWEEN ? AND ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(from));
            ps.setTimestamp(2, Timestamp.valueOf(to));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tickets.add(extractTicket(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }

    // Đếm số xe đang đỗ
    public int countActiveTickets() {
        String sql = "SELECT COUNT(*) FROM ticket WHERE is_active = true";
        try (Connection conn = DBConnection.getConnection(); Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private Ticket extractTicket(ResultSet rs) throws SQLException {
        Ticket t = new Ticket(
            rs.getString("ticket_code"),
            rs.getString("license_plate"),
            rs.getInt("vehicle_type_id"),
            rs.getTimestamp("entry_time").toLocalDateTime()
        );
        t.setId(rs.getInt("id"));
        Timestamp exitTs = rs.getTimestamp("exit_time");
        if (exitTs != null) t.setExitTime(exitTs.toLocalDateTime());
        t.setActive(rs.getBoolean("is_active"));
        return t;
    }
    
}
