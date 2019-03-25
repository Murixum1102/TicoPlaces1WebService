package com.ulatina.ticoplaces.webservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ulatina.ticoplaces.webservice.model.entity.Province;
import com.ulatina.ticoplaces.webservice.model.services.IProvinceService;

@RestController
@RequestMapping("/api")
public class ProvinceRestController {

	@Autowired
	private IProvinceService provinceService;
	
	@GetMapping("/provinces")
	public List<Province> index(){
		
		return provinceService.findAll();
	}
}
