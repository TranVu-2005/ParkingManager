/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingmanager.dao;

import com.mycompany.parkingmanager.model.ParkingInfo;
import com.mycompany.parkingmanager.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tran Vu
 */
public class ParkingInfoDAO {
    
    // Lấy thông tin tổng số chỗ của bãi đỗ
    public ParkingInfo getParkingInfo() throws SQLException {
        String sql = "SELECT * FROM parking_info LIMIT 1";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return new ParkingInfo(
                    rs.getInt("id"),
                    rs.getInt("total_slots"),
                    rs.getString("description")
                );
            }
        }
        return null;
    }

    // Cập nhật tổng số chỗ (nếu cần)
    public void updateTotalSlots(int id, int newSlots) throws SQLException {
        String sql = "UPDATE parking_info SET total_slots = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, newSlots);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
}
