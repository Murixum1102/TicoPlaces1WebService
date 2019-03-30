package com.ulatina.ticoplaces.webservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@PostMapping("/districts")
	@ResponseStatus(HttpStatus.CREATED)
	public District create(@RequestBody District district) {
		return districtService.save(district);
	}
	
	@PutMapping("/districts/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public District update(@RequestBody District district, @PathVariable Long id) {
		District districtActual = districtService.findById(id);
		
		districtActual.setDistrictName(district.getDistrictName());
		return districtService.save(districtActual);
	}
	
	@DeleteMapping("/district/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		districtService.delete(id);
	}
}
