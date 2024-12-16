package com.example.springmvccrud.controllers;

import com.example.springmvccrud.encapsulations.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VehicleController {

	@GetMapping("/")
	public String mainPage(Model model){
		return "mainPage";
	}
}
