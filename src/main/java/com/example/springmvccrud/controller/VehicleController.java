package com.example.springmvccrud.controller;

import com.example.springmvccrud.domain.entity.Vehicle;
import com.example.springmvccrud.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping()
	public String mainPage(Model model){
		model.addAttribute("vehicles", vehicleService.listVehicles());
		return "mainPage";
	}

	@GetMapping("create")
	public String createVehiclePage(Model model){
		model.addAttribute("vehicle", new Vehicle());
		return "createVehicle";
	}

	@PostMapping("create")
	public String saveVehicle(@ModelAttribute Vehicle vehicle, RedirectAttributes redirectAttributes){
		try {
			vehicleService.saveVehicle(vehicle);
			redirectAttributes.addFlashAttribute("Success!", "Vehicle created successfully!");
			return "redirect:/vehicles";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("Error!", "Error creating vehicle");
			return "redirect:/vehicles/create";
		}
	}

}
