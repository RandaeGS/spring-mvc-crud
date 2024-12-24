package com.example.springmvccrud.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private String model;
	private String type;
	private int fabricationYear;
	private String color;
	private double mileage;

	public Vehicle() {
	}

	public Vehicle(String brand, String model, String type, int fabricationYear, String color, double mileage) {
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.fabricationYear = fabricationYear;
		this.color = color;
		this.mileage = mileage;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFabricationYear() {
		return fabricationYear;
	}

	public void setFabricationYear(int fabricationYear) {
		this.fabricationYear = fabricationYear;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
}
