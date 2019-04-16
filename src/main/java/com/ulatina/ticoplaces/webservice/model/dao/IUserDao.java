package com.ulatina.ticoplaces.webservice.model.dao;

import org.springframework.data.repository.CrudRepository;
import com.ulatina.ticoplaces.webservice.model.entity.UserEntity;

public interface IUserDao extends CrudRepository <UserEntity,Long> {
	
	public UserEntity findByUsername(String username);

}
