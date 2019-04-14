package com.ulatina.ticoplaces.webservice.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.ulatina.ticoplaces.webservice.model.entity.User;

public interface IUserDao extends CrudRepository<User, Long>{

}
