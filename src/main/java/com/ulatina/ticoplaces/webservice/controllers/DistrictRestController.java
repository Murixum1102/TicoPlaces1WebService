package com.ulatina.ticoplaces.webservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ulatina.ticoplaces.webservice.model.entity.District;
import com.ulatina.ticoplaces.webservice.model.services.IDistrictService;

@RestController
@RequestMapping("/api")
public class DistrictRestController {
	
	@Autowired
	private IDistrictService districtService;
	
	@GetMapping("/districts")
	public List<District> index(){
		
		return districtService.findAll();
	}
	
	@GetMapping("districts/{id}")
	public District show(@PathVariable Long id) {
		return districtService.findById(id);
	}
}
