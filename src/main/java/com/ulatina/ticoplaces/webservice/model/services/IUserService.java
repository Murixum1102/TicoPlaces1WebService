package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import com.ulatina.ticoplaces.webservice.model.entity.UserEntity;

public interface IUserService {

	public UserEntity findByUsername(String username);

	public List<UserEntity> findAll();

	public UserEntity findById(Long id);

	public UserEntity save(UserEntity user);

	public void delete(Long id);
	
}
