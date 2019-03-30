package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulatina.ticoplaces.webservice.model.dao.IProvinceDao;
import com.ulatina.ticoplaces.webservice.model.entity.Province;

@Service
public class ProvinceServiceImpl implements IProvinceService{
	
	@Autowired
	private IProvinceDao provinceDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Province> findAll(){
		
		return (List<Province>)provinceDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Province findById(Long id) {
		
		return provinceDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Province save(Province province) {
		
		return provinceDao.save(province);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		provinceDao.deleteById(id);
	}

}
