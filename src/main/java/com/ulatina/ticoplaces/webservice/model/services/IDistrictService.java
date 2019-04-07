package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import com.ulatina.ticoplaces.webservice.model.entity.Canton;
import com.ulatina.ticoplaces.webservice.model.entity.District;
import com.ulatina.ticoplaces.webservice.model.entity.Province;

public interface IDistrictService {
	
	public List<District> findAll();

	public District findById(Long id);

	public District save(District district);

	public void delete(Long id);
	
	public List<Canton> findAllCantons();
}
