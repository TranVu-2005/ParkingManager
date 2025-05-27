/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingmanager.controller;

import com.mycompany.parkingmanager.model.ParkingInfo;
import com.mycompany.parkingmanager.service.ParkingInfoService;
import java.sql.SQLException;

/**
 *
 * @author Tran Vu
 */
public class ParkingInfoController {
    private ParkingInfoService service = new ParkingInfoService();

    public ParkingInfo getParkingInfo() throws SQLException {
        return service.getParkingInfo();
    }

    public int getAvailableSlots() throws SQLException {
        return service.getAvailableSlots();
    }
}
