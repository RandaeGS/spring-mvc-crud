package com.example.springmvccrud.encapsulations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @NoArgsConstructor @AllArgsConstructor
public class Vehicle {
	private long id;
	private String brand;
	private String model;
	private String type;
	private int fabricationYear;
	private @Setter String color;
	private @Setter double mileage;
}
