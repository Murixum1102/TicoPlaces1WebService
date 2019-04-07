package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulatina.ticoplaces.webservice.model.dao.ICantonDao;
import com.ulatina.ticoplaces.webservice.model.dao.IProvinceDao;
import com.ulatina.ticoplaces.webservice.model.entity.Canton;
import com.ulatina.ticoplaces.webservice.model.entity.Province;

@Service
public class CantonServiceImpl implements ICantonService{

	@Autowired
	private ICantonDao cantonDao;
	@Autowired
	private IProvinceDao provinceDao;
	@Override
	@Transactional(readOnly=true)
	public List<Canton> findAll() {
		
		return (List<Canton>)cantonDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Canton findById(Long id) {
		
		return cantonDao.findById(id).orElse(null);
	}

	@Override
	public Canton save(Canton canton) {
		return cantonDao.save(canton);
	}

	@Override
	public void delete(Long id) {
		cantonDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Province> findAllProvinces() {
		return cantonDao.findAllProvinces();
	}

	


}
