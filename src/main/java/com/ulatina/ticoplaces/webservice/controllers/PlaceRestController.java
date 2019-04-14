package com.ulatina.ticoplaces.webservice.controllers;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
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
import com.ulatina.ticoplaces.webservice.model.services.IUploadFileService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PlaceRestController {
	
	@Autowired
	private IPlaceService placeService;
	
	@Autowired
	private IUploadFileService uploadService;
	
	
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
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			//Borrar la foto asociada al Place
			Place place = placeService.findById(id);
			String nombreFoto = place.getPhoto();
			//Si la foto existe se borra al borrar el Place
			uploadService.eliminar(nombreFoto);
			
			placeService.delete(id);
		}catch(DataAccessException e) {
			//Respuesta Http del status de la operacion, error
			response.put("mensaje", "Error when trying to delete Place.");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//Respuesta Http del status de la operacion
		response.put("mensaje", "The Place was sucessfuly deleted.");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
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
	
	//Subir foto, upload
	@PostMapping("places/upload")
	public ResponseEntity<?> uploadPicture(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		
		Place place = placeService.findById(id);
		
		if(!archivo.isEmpty()) {
			
			String nombreArchivo = null;
			try {
				nombreArchivo = uploadService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error uploading picture: ");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			place.setPhoto(nombreArchivo);
			placeService.save(place);
			
			response.put("place", place);
			response.put("mensaje", "Photo uploaded correctly! Name: " + nombreArchivo);
		}	
		
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	//Mostrar foto en el browser
	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		
		Resource recurso = null;
		
		try {
			recurso = uploadService.cargar(nombreFoto);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(recurso, header, HttpStatus.OK);
	}
}
