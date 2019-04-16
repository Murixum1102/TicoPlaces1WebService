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

import com.ulatina.ticoplaces.webservice.model.entity.Canton;
import com.ulatina.ticoplaces.webservice.model.entity.Province;
import com.ulatina.ticoplaces.webservice.model.services.ICantonService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CantonRestController {

	@Autowired
	private ICantonService cantonService;

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("/cantones")
	public List<Canton> index() {

		return cantonService.findAll();
	}

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("cantones/{id}")
	public Canton show(@PathVariable Long id) {
		return cantonService.findById(id);
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("/cantones")
	@ResponseStatus(HttpStatus.CREATED)
	public Canton create(@RequestBody Canton canton) {

		return cantonService.save(canton);
	}

	@Secured({ "ROLE_ADMIN" })
	@PutMapping("/cantones/{id}")
	public Canton update(@RequestBody Canton canton, @PathVariable Long id) {
		Canton cantonActual = cantonService.findById(id);
		cantonActual.setName(canton.getName());
		cantonActual.setProvince(canton.getProvince());
		return cantonService.save(cantonActual);
	}

	@Secured({ "ROLE_ADMIN" })
	@DeleteMapping("/cantones/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		cantonService.delete(id);
	}

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("/cantones/provincias")
	@ResponseStatus(HttpStatus.OK)
	public List<Province> findAllProvinces() {
		return cantonService.findAllProvinces();
	}

}
