package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulatina.ticoplaces.webservice.model.dao.IProvinceDao;
import com.ulatina.ticoplaces.webservice.model.dao.ISubCategoryDao;
import com.ulatina.ticoplaces.webservice.model.entity.Province;
import com.ulatina.ticoplaces.webservice.model.entity.SubCategory;

@Service
public class SubCategoryService implements ISubCategoryService{

	@Autowired
	private ISubCategoryDao subCategoryDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<SubCategory> findAll(){
			
			return (List<SubCategory>)subCategoryDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public SubCategory findById(Long id) {
		return subCategoryDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public SubCategory save(SubCategory subCategory) {
		return subCategoryDao.save(subCategory);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		subCategoryDao.deleteById(id);
		
	}

}
