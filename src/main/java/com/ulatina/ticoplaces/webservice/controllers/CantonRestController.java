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

import com.ulatina.ticoplaces.webservice.model.entity.Canton;
import com.ulatina.ticoplaces.webservice.model.services.ICantonService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins= {"*"})
public class CantonRestController {

	@Autowired
	private ICantonService cantonService;
	
	@GetMapping("/cantones")
	public List<Canton> index(){
		
		return cantonService.findAll();
	}
	
	@GetMapping("cantones/{id}")
	public Canton show(@PathVariable Long id) {
		return cantonService.findById(id);
	}
	
	@PostMapping("/cantones/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Canton create(@RequestBody Canton canton) {
		return cantonService.save(canton);
	}
	
	@PutMapping("/cantones/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Canton update(@RequestBody Canton canton, @PathVariable Long id) {
		Canton cantonActual = cantonService.findById(id);
		
		cantonActual.setName(canton.getName());
		return cantonService.save(cantonActual);
	}
	
	@DeleteMapping("/cantones/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		cantonService.delete(id);
	}
}
