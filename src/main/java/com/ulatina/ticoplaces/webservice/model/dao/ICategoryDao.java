package com.ulatina.ticoplaces.webservice.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.ulatina.ticoplaces.webservice.model.entity.Category;

public interface ICategoryDao extends CrudRepository<Category, Long>{
	
	public List<Category> findByDescriptionContainingIgnoreCase(String term);
}
