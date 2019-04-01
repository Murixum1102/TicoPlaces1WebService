package com.ulatina.ticoplaces.webservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ulatina.ticoplaces.webservice.model.entity.Category;
import com.ulatina.ticoplaces.webservice.model.entity.Place;
import com.ulatina.ticoplaces.webservice.model.services.ICategoryService;
import com.ulatina.ticoplaces.webservice.model.services.IPlaceService;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> index(){
		return categoryService.findAll();
	}
	
	@GetMapping("/categories/{id}")
	public Category show(@PathVariable Long id) {
		return categoryService.findById(id);
	}
}
