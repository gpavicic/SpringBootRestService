package com.company.goxy.service;

import com.company.goxy.dao.UserDAO;
import com.company.goxy.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class UserServiceBean implements UserService {
	@Autowired
	UserDAO userDAO;

	@Override
	public Collection<User> findAll() {
		Iterable<User> usersI = userDAO.findAll();
		Collection<User> users = StreamSupport.stream(usersI.spliterator(),false).collect(Collectors.toList());
		return users;
	}

	@Override
	public User findOne(Long id) {
		return (User) userDAO.findOne(id);
	}

	@Override
	public User save(User user) {
		userDAO.save(user);		
		return (User) userDAO.findOne(user.getId());
	}

	@Override
	public User update(User user) {
		userDAO.save(user);	
		return (User) userDAO.findOne(user.getId());
	}

	@Override
	public void delete(Long id) {
		userDAO.delete(id);

	}

}
