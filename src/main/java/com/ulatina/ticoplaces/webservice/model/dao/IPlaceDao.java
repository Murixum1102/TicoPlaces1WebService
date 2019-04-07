package com.ulatina.ticoplaces.webservice.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ulatina.ticoplaces.webservice.model.entity.Canton;
import com.ulatina.ticoplaces.webservice.model.entity.Category;
import com.ulatina.ticoplaces.webservice.model.entity.District;
import com.ulatina.ticoplaces.webservice.model.entity.Place;
import com.ulatina.ticoplaces.webservice.model.entity.Province;

public interface IPlaceDao extends CrudRepository<Place, Long>{

	@Query("from Canton")
	public List<Canton> findAllCantons();
	@Query("from Province")
	public List<Province> findAllProvinces();
	@Query("from District")
	public List<District> findAllDistricts();
	@Query("from Category")
	public List<Category> findAllCategories();
}
