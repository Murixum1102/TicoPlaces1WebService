package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import com.ulatina.ticoplaces.webservice.model.entity.Canton;
import com.ulatina.ticoplaces.webservice.model.entity.Province;

public interface ICantonService {

	public List<Canton> findAll();
	
	public Canton findById(Long id);

	public Canton save(Canton canton);

	public void delete(Long id);
	
	public List<Province> findAllProvinces();
}
