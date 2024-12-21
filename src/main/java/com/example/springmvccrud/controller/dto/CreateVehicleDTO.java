package com.example.springmvccrud.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateVehicleDTO {
	private String brand;
	private String model;
	private String type;
	private int fabricationYear;
	private String color;
	private double mileage;
}
