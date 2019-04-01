package com.ulatina.ticoplaces.webservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ulatina.ticoplaces.webservice.model.entity.Place;
import com.ulatina.ticoplaces.webservice.model.services.IPlaceService;

@RestController
@RequestMapping("/api")
public class PlaceRestController {
	
	@Autowired
	private IPlaceService placeService;
	
	@GetMapping("/places")
	public List<Place> index(){
		return placeService.findAll();
	}
	
	@GetMapping("/places/{id}")
	public Place show(@PathVariable Long id) {
		return placeService.findById(id);
	}

}
