package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import com.ulatina.ticoplaces.webservice.model.entity.Canton;
import com.ulatina.ticoplaces.webservice.model.entity.Category;
import com.ulatina.ticoplaces.webservice.model.entity.District;
import com.ulatina.ticoplaces.webservice.model.entity.Place;
import com.ulatina.ticoplaces.webservice.model.entity.Province;

public interface IPlaceService {
	
    public List<Place> findAll();
	
	public Place findById(Long id);
	
	public Place save(Place place);
	
	public void delete(Long id);
	
	public List<Canton> findAllCantons();
	
	public List<Province> findAllProvinces();
	
	public List<District> findAllDistricts();
	
	public List<Category> findAllCategories();
	
}
