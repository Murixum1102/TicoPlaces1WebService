package com.ulatina.ticoplaces.webservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.ulatina.ticoplaces.webservice.model.services.IProvinceService;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProvinceRestController {

	@Autowired
	private IProvinceService provinceService;
	
	@GetMapping("/provinces")
	public List<Province> index(){
		
		return provinceService.findAll();
	}
	
	@GetMapping("provinces/{id}")
	public Province show(@PathVariable Long id) {
		return provinceService.findById(id);
	}
	@PostMapping("/provinces")
	@ResponseStatus(HttpStatus.CREATED)
	public Province create(@RequestBody Province province) {
		
		return provinceService.save(province);
	}
	@PutMapping("/provinces/{id}")
	public Province update (@RequestBody Province province, @PathVariable Long id) {
		Province provinceActual = provinceService.findById(id);
		provinceActual.setProvinceName(province.getProvinceName());
		return provinceService.save(provinceActual);
	}
	
	@DeleteMapping("/provinces/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		provinceService.delete(id);
	}
}
