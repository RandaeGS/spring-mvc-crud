package com.example.springmvccrud.service;

import com.example.springmvccrud.domain.entity.Vehicle;
import com.example.springmvccrud.domain.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> listVehicles(){
		return vehicleRepository.findAll();
	}

	public void saveVehicle(Vehicle vehicle){
		vehicleRepository.save(vehicle);
	}
}
