/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingmanager.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Tran Vu
 */
public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection != null) return connection;

        try {
            // Load driver (nếu cần)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Cấu hình trực tiếp chuỗi kết nối
            String url = "jdbc:mysql://localhost:3306/parking_system"; 
            String user = "root";                                   // Username MySQL
            String password = "";                                   // Password MySQL (nếu có thì điền)

            // Tạo kết nối
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Kết nối thành công đến database!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Không thể kết nối đến database:");
            e.printStackTrace();
        }

        return connection;
    }
}
