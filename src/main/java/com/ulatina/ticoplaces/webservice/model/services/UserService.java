package com.ulatina.ticoplaces.webservice.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulatina.ticoplaces.webservice.model.dao.IUserDao;
import com.ulatina.ticoplaces.webservice.model.entity.UserEntity;

@Service
public class UserService implements IUserService,UserDetailsService{

	private Logger logger= LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	UserEntity userEntity = userDao.findByUsername(username);
	if(userEntity == null) {
	
		logger.error("Error login: no existe el usuario'"+username+"'en el sistema");
			throw new UsernameNotFoundException("Error login: no existe el usuario'"+username+"'en el sistema");
	}
	List<GrantedAuthority> authorities = userEntity.getRoles()
			.stream()
			.map(role -> new SimpleGrantedAuthority(role.getName()))
			.peek(authority -> logger.info("Role:"+ authority.getAuthority()))
			.collect(Collectors.toList());
	
		return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getEnable(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly=true)
	public UserEntity findByUsername(String username) {
		
		return userDao.findByUsername(username);
	}

}
