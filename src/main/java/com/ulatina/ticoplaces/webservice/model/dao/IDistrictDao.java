package com.ulatina.ticoplaces.webservice.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ulatina.ticoplaces.webservice.model.entity.Canton;
import com.ulatina.ticoplaces.webservice.model.entity.District;

public interface IDistrictDao extends CrudRepository<District, Long>{

	@Query("from Canton")
	public List<Canton> findAllCantons();
	public List<District> findByDistrictNameContainingIgnoreCase(String term);
}
