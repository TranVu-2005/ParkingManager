/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingmanager.service;

import com.mycompany.parkingmanager.dao.VehicleTypeDAO;
import com.mycompany.parkingmanager.model.VehicleType;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tran Vu
 */
public class VehicleTypeService {
   private VehicleTypeDAO vehicleTypeDAO = new VehicleTypeDAO();

    public List<VehicleType> getAllVehicleTypes() throws SQLException {
        return vehicleTypeDAO.getAllVehicleTypes();
    }

    public VehicleType getById(int id) throws SQLException {
        return vehicleTypeDAO.getById(id);
    }
}
