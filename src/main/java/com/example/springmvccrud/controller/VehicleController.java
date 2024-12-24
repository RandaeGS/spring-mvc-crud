package com.example.springmvccrud.controller;

import com.example.springmvccrud.domain.entity.Vehicle;
import com.example.springmvccrud.domain.repository.VehicleRepository;
import com.example.springmvccrud.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VehicleRepository vehicleRepository;

	@GetMapping()
	public String mainPage(Model model){
		model.addAttribute("vehicles", vehicleService.listVehicles());
		return "mainPage";
	}

	@GetMapping("create")
	public String createVehiclePage(Model model){
		model.addAttribute("vehicle", new Vehicle());
		return "vehicleForm";
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

	@GetMapping("edit/{id}")
	public String editVehiclePage(@PathVariable("id") Long vehicleId, Model model){
		Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
		model.addAttribute("vehicle", vehicle);
		return "vehicleForm";
	}

	@PostMapping("/edit/{id}")
	public String editVehicleForm(@ModelAttribute Vehicle vehicle, @PathVariable("id") Long vehicleId){
		vehicle.setId(vehicleId);
		vehicleRepository.save(vehicle);
		return "redirect:/vehicles";
	}

	@PostMapping("delete/{id}")
	public String deleteVehicle(@PathVariable("id") Long vehicleId){
		Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
		Vehicle vehicle = vehicleOptional.get();
		vehicleRepository.delete(vehicle);
		return "redirect:/vehicles";
	}

}
