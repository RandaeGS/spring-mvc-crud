package com.example.springmvccrud.controller;

import com.example.springmvccrud.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/")
	public String mainPage(Model model){
		model.addAttribute("vehicles", vehicleService.listVehicles());
		return "mainPage";
	}
}
