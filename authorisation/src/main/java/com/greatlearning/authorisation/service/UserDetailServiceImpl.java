package com.greatlearning.authorisation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.authorisation.dao.UserRepository;
import com.greatlearning.authorisation.model.User;
import com.greatlearning.authorisation.security.MyUserDetails;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByName(username);
		if(user==null) {
			throw new UsernameNotFoundException(username+"not found");
		}
		MyUserDetails userDetails =new MyUserDetails(user);
		
		return userDetails;
	}
}
