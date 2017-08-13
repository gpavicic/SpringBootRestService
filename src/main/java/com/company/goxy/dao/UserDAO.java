package com.company.goxy.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.goxy.model.User;


@Repository
public interface UserDAO<T extends User> extends CrudRepository<T, Long> {
}
