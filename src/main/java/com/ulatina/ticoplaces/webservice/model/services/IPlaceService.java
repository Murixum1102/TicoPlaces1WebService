package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import com.ulatina.ticoplaces.webservice.model.entity.Place;

public interface IPlaceService {
	
	public List<Place> findAll();
	
	public Place findById(Long id);

}
