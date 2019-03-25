package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulatina.ticoplaces.webservice.model.dao.ICantonDao;
import com.ulatina.ticoplaces.webservice.model.entity.Canton;

@Service
public class CantonServiceImpl implements ICantonService{

	@Autowired
	private ICantonDao cantonDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Canton> findAll() {
		
		return (List<Canton>)cantonDao.findAll();
	}

}
