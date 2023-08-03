package com.greatlearning.authorisation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.authorisation.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	 User findByName(String name);

}
