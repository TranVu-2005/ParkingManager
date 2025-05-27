/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingmanager.service;

import com.mycompany.parkingmanager.dao.ParkingInfoDAO;
import com.mycompany.parkingmanager.dao.TicketDAO;
import com.mycompany.parkingmanager.model.ParkingInfo;
import java.sql.SQLException;

/**
 *
 * @author Tran Vu
 */
public class ParkingInfoService {
    private ParkingInfoDAO parkingInfoDAO = new ParkingInfoDAO();
    private TicketDAO ticketDAO = new TicketDAO();

    public ParkingInfo getParkingInfo() throws SQLException {
        return parkingInfoDAO.getParkingInfo();
    }

    public int getAvailableSlots() throws SQLException {
        ParkingInfo info = parkingInfoDAO.getParkingInfo();
        int total = info.getTotalSlots();
        int used = ticketDAO.countActiveTickets();
        return total - used;
    }
}
