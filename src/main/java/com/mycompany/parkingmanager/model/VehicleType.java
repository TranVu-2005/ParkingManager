/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingmanager.model;

/**
 *
 * @author Tran Vu
 */
public class VehicleType {
    private int id;         
    private String name;    

    public VehicleType() {
    }

    public VehicleType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Hiển thị thông tin loại xe
    @Override
    public String toString() {
        return "VehicleType{id=" + id + ", name='" + name + "'}";
    }
}
