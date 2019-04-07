package com.ulatina.ticoplaces.webservice.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.ulatina.ticoplaces.webservice.model.entity.Province;

public interface IProvinceDao extends CrudRepository<Province, Long>{
	
public List<Province> findByProvinceNameContainingIgnoreCase(String term);

}
