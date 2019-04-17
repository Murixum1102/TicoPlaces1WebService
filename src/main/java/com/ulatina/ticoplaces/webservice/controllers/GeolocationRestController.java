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

import com.ulatina.ticoplaces.webservice.model.entity.GeolocationLog;
import com.ulatina.ticoplaces.webservice.model.services.IGeolocationService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class GeolocationRestController {

	@Autowired
	private IGeolocationService geoService;
	
	@GetMapping("/geolocations")
	public List<GeolocationLog> index() {
		return geoService.findAll();
	}
	
	@GetMapping("geolocation/{id}")
	public GeolocationLog show(@PathVariable Long id) {
		return geoService.findById(id);
	}
	
	@PostMapping("/geolocations")
	@ResponseStatus(HttpStatus.CREATED)
	public GeolocationLog create(@RequestBody GeolocationLog geoLocation) {
		return geoService.save(geoLocation);
	}
	
	@PutMapping("/geolocations/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public GeolocationLog update(@RequestBody GeolocationLog geoLocation, @PathVariable Long id) {
		GeolocationLog geoActual = geoService.findById(id);
		
		geoActual.setLongitud(geoLocation.getLongitud());
		geoActual.setLatitud(geoLocation.getLatitud());
		geoActual.setDateTime(geoLocation.getDateTime());
		geoActual.setActividad(geoLocation.getActividad());
		
		return geoService.save(geoActual);
	}
	
	@DeleteMapping("geolocations/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		geoService.delete(id);
	}
}
