package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulatina.ticoplaces.webservice.model.dao.IDistrictDao;
import com.ulatina.ticoplaces.webservice.model.entity.District;

@Service
public class DistrictServiceImpl implements IDistrictService{


		@Autowired
		private IDistrictDao districtDao;
		
		@Override
		@Transactional(readOnly=true)
		public List<District> findAll() {
			
			return (List<District>)districtDao.findAll();
		}

		@Override
		@Transactional(readOnly=true)
		public District findById(Long id) {
			
			return districtDao.findById(id).orElse(null);
		}

		@Override
		public District save(District district) {
			return districtDao.save(district);
		}

		@Override
		public void delete(Long id) {
			districtDao.deleteById(id);
		}

	
}
