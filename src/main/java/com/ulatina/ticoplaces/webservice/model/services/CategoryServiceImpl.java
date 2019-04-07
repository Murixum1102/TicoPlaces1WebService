package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulatina.ticoplaces.webservice.model.dao.ICategoryDao;
import com.ulatina.ticoplaces.webservice.model.entity.Category;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private ICategoryDao categoryDao;

	@Override
	@Transactional(readOnly=true)
	public List<Category> findAll() {
		
		return (List<Category>)categoryDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Category findById(Long id) {
		
		return categoryDao.findById(id).orElse(null);
	}

	@Override
	public Category save(Category category) {
		return categoryDao.save(category);
	}

	@Override
	public void delete(Long id) {
		categoryDao.deleteById(id);
		
	}

}
