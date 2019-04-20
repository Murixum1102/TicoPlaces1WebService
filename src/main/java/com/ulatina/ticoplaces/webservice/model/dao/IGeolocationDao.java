package com.ulatina.ticoplaces.webservice.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.ulatina.ticoplaces.webservice.model.entity.GeolocationLog;

public interface IGeolocationDao extends CrudRepository<GeolocationLog, Long> {

}
