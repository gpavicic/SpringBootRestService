package com.company.goxy.service;

import java.util.Collection;

import com.company.goxy.model.User;

public interface UserService {
	
	Collection<User> findAll();

	User findOne(Long id);

	User save(User user);

	User update(User user);

	void delete(Long id);

}
