package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;

import com.ulatina.ticoplaces.webservice.model.entity.User;

public interface IUserService {
	
	public List<User> findAll();
	
	public User findById(Long id);
	
	public User save(User user);
	
	public void delete(Long id);

}
