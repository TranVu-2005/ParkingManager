/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingmanager.service;

import com.mycompany.parkingmanager.dao.TicketDAO;
import com.mycompany.parkingmanager.dao.VehicleTypeDAO;
import com.mycompany.parkingmanager.model.Ticket;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.time.LocalDateTime;

/**
 *
 * @author Tran Vu
 */
public class TicketService {
    private TicketDAO ticketDAO = new TicketDAO();

     public void enterVehicleWithTypeName(Ticket ticket, String vehicleTypeName) {
        ticketDAO.insertTicketWithVehicleTypeName(ticket, vehicleTypeName);
    }

    public void exitVehicle(String ticketCode) {
        ticketDAO.exitTicket(ticketCode);
    }


    public Ticket searchByTicketCode(String ticketCode) throws SQLException {
        return ticketDAO.findByTicketCode(ticketCode);
    }

    public List<Ticket> searchByDateRange(LocalDateTime from, LocalDateTime to) throws SQLException {
        return ticketDAO.findByDateRange(from, to);
    }

    public int getActiveTicketCount() throws SQLException {
        return ticketDAO.countActiveTickets();
    }
    
//    public void addTicketWithVehicleName(Ticket ticket, String vehicleTypeName) throws SQLException {
//    VehicleTypeDAO vdao = new VehicleTypeDAO();
//    int typeId = vdao.getVehicleTypeIdByName(vehicleTypeName);
//    ticket.setVehicleTypeId(typeId);
//    ticketDAO.insertTicket(ticket);
//    }
    
    public List<Ticket> getAllTicketsWithVehicleTypeName() throws SQLException {
        return ticketDAO.getAllTicketsWithVehicleTypeName();
    }
    
    public int getRemainingSlots() {
        return ticketDAO.getRemainingSlots();
    }

    
}

