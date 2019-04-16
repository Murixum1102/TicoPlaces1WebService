package com.ulatina.ticoplaces.webservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ulatina.ticoplaces.webservice.model.entity.Province;
import com.ulatina.ticoplaces.webservice.model.entity.SubCategory;
import com.ulatina.ticoplaces.webservice.model.services.IProvinceService;
import com.ulatina.ticoplaces.webservice.model.services.ISubCategoryService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class SubCategoryRestController {
	@Autowired
	private ISubCategoryService subCategoryService;
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/subcategories")
	public List<SubCategory> index(){
		
		return subCategoryService.findAll();
	}
	@Secured({"ROLE_ADMIN"})
	@GetMapping("subcategories/{id}")
	public SubCategory show(@PathVariable Long id) {
		return subCategoryService.findById(id);
	}
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/subcategories")
	@ResponseStatus(HttpStatus.CREATED)
	public SubCategory create(@RequestBody SubCategory subCategory) {
		
		return subCategoryService.save(subCategory);
	}
	@Secured({"ROLE_ADMIN"})
	@PutMapping("/subcategories/{id}")
	public SubCategory update (@RequestBody SubCategory subCategory, @PathVariable Long id) {
		SubCategory subcategoriaActual = subCategoryService.findById(id);
		subcategoriaActual.setDescription(subCategory.getDescription());
		return subCategoryService.save(subcategoriaActual);
	}
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/subcategories/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		subCategoryService.delete(id);
	}
}
