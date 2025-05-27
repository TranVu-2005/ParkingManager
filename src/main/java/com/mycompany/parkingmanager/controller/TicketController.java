/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingmanager.controller;

import com.mycompany.parkingmanager.model.Ticket;
import com.mycompany.parkingmanager.service.TicketService;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Tran Vu
 */
public class TicketController {
    private TicketService service = new TicketService();

    public void enterVehicle(Ticket ticket, String vehicleTypeName) {
        service.enterVehicleWithTypeName(ticket, vehicleTypeName);
    }

    public void exitVehicle(String ticketCode) {
        service.exitVehicle(ticketCode);
    }


    public Ticket searchByTicketCode(String code) throws SQLException {
        return service.searchByTicketCode(code);
    }

    public List<Ticket> searchByDate(LocalDateTime from, LocalDateTime to) throws SQLException {
        return service.searchByDateRange(from, to);
    }
    
    
//    public List<Ticket> getAllTicketsWithVehicleTypeName() throws SQLException {
//        return service.getAllTicketsWithVehicleTypeName();
//    }
//    
    
    public List<Ticket> getAllTickets() throws SQLException {
        return service.getAllTicketsWithVehicleTypeName();
    }

    
    public int getRemainingSlots() {
        return service.getRemainingSlots();
    }

}
