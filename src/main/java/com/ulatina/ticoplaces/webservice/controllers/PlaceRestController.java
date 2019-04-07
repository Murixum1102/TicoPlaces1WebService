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
import com.ulatina.ticoplaces.webservice.model.entity.Category;
import com.ulatina.ticoplaces.webservice.model.entity.District;
import com.ulatina.ticoplaces.webservice.model.entity.Place;
import com.ulatina.ticoplaces.webservice.model.entity.Province;
import com.ulatina.ticoplaces.webservice.model.services.IPlaceService;

@CrossOrigin(origins = {"http://localhost:4200"})
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
	
	@PostMapping("/places")
	@ResponseStatus(HttpStatus.CREATED)
	public Place create(@RequestBody Place place) {
		return placeService.save(place);
	}
	
	@PutMapping("/places/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Place update(@RequestBody Place place, @PathVariable Long id) {
		Place placeActual = placeService.findById(id);
		
		placeActual.setPlaceName(place.getPlaceName());
		placeActual.setLongitude(place.getLongitude());
		placeActual.setLatitude(place.getLatitude());
		placeActual.setProvincia(place.getProvincia());
		placeActual.setCantonPlace(place.getCantonPlace());
		placeActual.setDistrito(place.getDistrito());
		placeActual.setCategory(place.getCategory());
		return placeService.save(placeActual);
	}
	
	@DeleteMapping("/places/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		placeService.delete(id);
	}
	@GetMapping("/places/provincias")
	@ResponseStatus(HttpStatus.OK)
	public List<Province> findAllProvinces() {
		return placeService.findAllProvinces();
	}
	@GetMapping("/places/cantones")
	@ResponseStatus(HttpStatus.OK)
	public List<Canton> findAllCantons() {
		return placeService.findAllCantons();
	}
	@GetMapping("/places/distritos")
	@ResponseStatus(HttpStatus.OK)
	public List<District> findAllDistricts() {
		return placeService.findAllDistricts();
	}
	@GetMapping("/places/categorias")
	@ResponseStatus(HttpStatus.OK)
	public List<Category> findAllCategory() {
		return placeService.findAllCategories();
	}
}
