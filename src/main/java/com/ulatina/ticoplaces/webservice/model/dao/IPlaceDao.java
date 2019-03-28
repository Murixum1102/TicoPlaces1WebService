package com.ulatina.ticoplaces.webservice.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.ulatina.ticoplaces.webservice.model.entity.Place;

public interface IPlaceDao extends CrudRepository<Place, Long>{

}
