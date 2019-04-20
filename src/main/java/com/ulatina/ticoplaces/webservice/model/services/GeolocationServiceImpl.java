package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulatina.ticoplaces.webservice.model.dao.IGeolocationDao;
import com.ulatina.ticoplaces.webservice.model.entity.GeolocationLog;

@Service
public class GeolocationServiceImpl implements IGeolocationService {
	@Autowired
	private IGeolocationDao geoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<GeolocationLog> findAll() {
		return (List<GeolocationLog>) geoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public GeolocationLog findById(Long id) {
		return geoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public GeolocationLog save(GeolocationLog geolog) {
		return geoDao.save(geolog);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		geoDao.deleteById(id);		
		
	}

}
