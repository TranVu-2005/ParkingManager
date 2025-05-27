/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingmanager.controller;

import com.mycompany.parkingmanager.model.VehicleType;
import com.mycompany.parkingmanager.service.VehicleTypeService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tran Vu
 */
public class VehicleTypeController {
    private VehicleTypeService service = new VehicleTypeService();

    public List<VehicleType> getAllVehicleTypes() throws SQLException {
        return service.getAllVehicleTypes();
    }

    public VehicleType getVehicleTypeById(int id) throws SQLException {
        return service.getById(id);
    }
}
