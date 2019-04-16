package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import com.ulatina.ticoplaces.webservice.model.entity.SubCategory;

public interface ISubCategoryService {
	
    public List<SubCategory> findAll();
	
	public SubCategory findById(Long id);

	public SubCategory save(SubCategory subCategory);

	public void delete(Long id);
}
