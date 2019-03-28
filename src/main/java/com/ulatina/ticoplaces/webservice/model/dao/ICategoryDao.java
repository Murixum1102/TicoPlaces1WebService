package com.ulatina.ticoplaces.webservice.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.ulatina.ticoplaces.webservice.model.entity.Category;

public interface ICategoryDao extends CrudRepository<Category, Long>{

}
