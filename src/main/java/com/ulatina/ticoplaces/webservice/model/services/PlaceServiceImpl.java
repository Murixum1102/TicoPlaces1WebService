package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulatina.ticoplaces.webservice.model.dao.IPlaceDao;
import com.ulatina.ticoplaces.webservice.model.entity.Place;

@Service
public class PlaceServiceImpl implements IPlaceService{
	
	@Autowired
	private IPlaceDao placeDao;

	@Override
	@Transactional(readOnly=true)
	public List<Place> findAll() {
		
		return (List<Place>)placeDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Place findById(Long id) {
	
		return placeDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Place save(Place place) {
		
		return placeDao.save(place);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		placeDao.deleteById(id);
	}

}
