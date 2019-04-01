package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import com.ulatina.ticoplaces.webservice.model.entity.Province;

public interface IProvinceService {
	
	public List<Province> findAll();
	
	public Province findById(Long id);

	public Province save(Province province);

	public void delete(Long id);

}
