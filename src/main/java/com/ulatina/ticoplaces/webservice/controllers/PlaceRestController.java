package com.ulatina.ticoplaces.webservice.controllers;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@PostMapping("places/upload")
	public ResponseEntity<?> uploadPicture(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		
		Place place = placeService.findById(id);
		
		if(!archivo.isEmpty()) {
			String nombreArchivo = archivo.getOriginalFilename();
			//Ruta absoluta desde donde se van a subir las imagenes. Se debe cambiar al unir con FrontEnd
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			place.setPhoto(nombreArchivo);
			placeService.save(place);
			
			response.put("place", place);
			response.put("mensaje", "Photo uploaded correctly! Name: " + nombreArchivo);
		}	
		
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
}
