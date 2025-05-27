/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingmanager.model;

/**
 *
 * @author Tran Vu
 */
public class ParkingInfo {
    private int id;
    private int totalSlots;
    private String description;

    public ParkingInfo() {
    }

    public ParkingInfo(int id, int totalSlots, String description) {
        this.id = id;
        this.totalSlots = totalSlots;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ParkingInfo{" + "id=" + id + ", totalSlots=" + totalSlots + ", description=" + description + '}';
    }
    
    
}
