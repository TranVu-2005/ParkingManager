/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingmanager.model;

import java.time.LocalDateTime;

/**
 *
 * @author Tran Vu
 */
public class Ticket {
    private int id;
    private String ticketCode;
    private String licensePlate;
    private int vehicleTypeId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private boolean isActive;
    private String vehicleTypeName;



    public Ticket(String ticketCode, String licensePlate, int vehicleTypeId, LocalDateTime entryTime) {
        this.ticketCode = ticketCode;
        this.licensePlate = licensePlate;
        this.vehicleTypeId = vehicleTypeId;
        this.entryTime = entryTime;
        this.isActive = true;
    }

    public Ticket(int id, String ticketCode, String licensePlate, int vehicleTypeId, LocalDateTime entryTime, LocalDateTime exitTime, boolean isActive) {
        this.id = id;
        this.ticketCode = ticketCode;
        this.licensePlate = licensePlate;
        this.vehicleTypeId = vehicleTypeId;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.isActive = isActive;
    }

    public Ticket() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public boolean IsActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public String getVehicleTypeName() {
    return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", ticketCode=" + ticketCode + ", licensePlate=" + licensePlate + ", vehicleTypeId=" + vehicleTypeId + ", entryTime=" + entryTime + ", exitTime=" + exitTime + ", isActive=" + isActive + '}';
    }

}

    
