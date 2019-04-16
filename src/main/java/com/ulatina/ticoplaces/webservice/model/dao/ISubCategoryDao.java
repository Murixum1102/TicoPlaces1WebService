package com.ulatina.ticoplaces.webservice.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ulatina.ticoplaces.webservice.model.entity.Province;
import com.ulatina.ticoplaces.webservice.model.entity.SubCategory;

public interface ISubCategoryDao extends CrudRepository<SubCategory, Long>{

	public List<SubCategory> findByDescriptionContainingIgnoreCase(String term);
}
