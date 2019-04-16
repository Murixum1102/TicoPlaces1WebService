package com.ulatina.ticoplaces.webservice.model.services;

import com.ulatina.ticoplaces.webservice.model.entity.UserEntity;

public interface IUserService {

	public UserEntity findByUsername(String username);
}
