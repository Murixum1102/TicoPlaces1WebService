package com.ulatina.ticoplaces.webservice.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ulatina.ticoplaces.webservice.model.entity.Canton;
import com.ulatina.ticoplaces.webservice.model.entity.Province;

public interface ICantonDao extends CrudRepository<Canton, Long>{

	@Query("from Province")
	public List<Province> findAllProvinces();
	public List<Canton> findByNameContainingIgnoreCase(String term);
}
