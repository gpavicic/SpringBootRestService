package com.company.goxy.service;

import java.util.Collection;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.goxy.model.User;
import com.company.goxy.dao.UserDAO;

public class UserServiceBean implements UserService {
	@Autowired
	UserDAO userDAO;

	@Override
	public Collection<User> findAll() {
		Iterable<User> usersI = userDAO.findAll();
		Collection<User> users = Lists.newArrayList(usersI);
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
