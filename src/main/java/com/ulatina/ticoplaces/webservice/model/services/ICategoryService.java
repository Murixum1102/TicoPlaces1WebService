package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;


import com.ulatina.ticoplaces.webservice.model.entity.Category;

public interface ICategoryService {
	
	public List<Category> findAll();
	
	public Category findById(Long id);
	
	public Category save(Category category);

	public void delete(Long id);
}
