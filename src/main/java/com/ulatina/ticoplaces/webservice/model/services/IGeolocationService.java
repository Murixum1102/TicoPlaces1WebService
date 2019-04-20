package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import com.ulatina.ticoplaces.webservice.model.entity.GeolocationLog;

public interface IGeolocationService {
	public List<GeolocationLog> findAll();

	public GeolocationLog findById(Long id);

	public GeolocationLog save(GeolocationLog geolog);

	public void delete(Long id);
}
