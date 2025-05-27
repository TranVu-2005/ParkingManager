/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingmanager.dao;

import com.mycompany.parkingmanager.model.VehicleType;
import com.mycompany.parkingmanager.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Vu
 */
public class VehicleTypeDAO {
    
    // Lấy toàn bộ danh sách loại xe từ DB
    public List<VehicleType> getAllVehicleTypes() throws SQLException {
        List<VehicleType> types = new ArrayList<>();
        String sql = "SELECT * FROM vehicle_type";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                VehicleType type = new VehicleType();
                type.setId(rs.getInt("id"));
                type.setName(rs.getString("name"));
                types.add(type);
            }
        }

        return types;
    }

    // Thêm loại xe mới (nếu cần)
    public void insertVehicleType(String name) throws SQLException {
        String sql = "INSERT INTO vehicle_type (name) VALUES (?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }

    // Lấy VehicleType theo id
    public VehicleType getById(int id) throws SQLException {
        String sql = "SELECT * FROM vehicle_type WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new VehicleType(rs.getInt("id"), rs.getString("name"));
                }
            }
        }
        return null;
    }
    
    public int getVehicleTypeIdByName(String name) throws SQLException {
    String sql = "SELECT id FROM vehicle_type WHERE name = ?";
    try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, name);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
    }
    throw new SQLException("Loại xe không tồn tại: " + name);
}

}
