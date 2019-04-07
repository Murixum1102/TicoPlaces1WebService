package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulatina.ticoplaces.webservice.model.dao.IPlaceDao;
import com.ulatina.ticoplaces.webservice.model.entity.Canton;
import com.ulatina.ticoplaces.webservice.model.entity.Category;
import com.ulatina.ticoplaces.webservice.model.entity.District;
import com.ulatina.ticoplaces.webservice.model.entity.Place;
import com.ulatina.ticoplaces.webservice.model.entity.Province;

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

	@Override
	@Transactional(readOnly=true)
	public List<Canton> findAllCantons() {
		return placeDao.findAllCantons();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Province> findAllProvinces() {
		return placeDao.findAllProvinces();
	}

	@Override
	@Transactional(readOnly=true)
	public List<District> findAllDistricts() {
		return placeDao.findAllDistricts();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Category> findAllCategories() {
		return placeDao.findAllCategories();
	}

}
