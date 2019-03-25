package com.ulatina.ticoplaces.webservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ulatina.ticoplaces.webservice.model.entity.Canton;
import com.ulatina.ticoplaces.webservice.model.services.ICantonService;

@RestController
@RequestMapping("/api")
public class CantonRestController {

	@Autowired
	private ICantonService cantonService;
	
	@GetMapping("/cantones")
	public List<Canton> index(){
		
		return cantonService.findAll();
	}
}
