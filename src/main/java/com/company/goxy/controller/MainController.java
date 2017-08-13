package com.company.goxy.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.goxy.model.User;
import com.company.goxy.service.UserService;


@RestController
public class MainController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/api/users", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<User>> getUsers() {
	Collection<User> users = userService.findAll();
	
	return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value="/api/users/{id}", 
				method = RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") Long id){
		User user = userService.findOne(id);
	
	 if (user == null) {
	        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	    }
	
	return new ResponseEntity<User>(user, HttpStatus.OK);		
	}

	@RequestMapping(value="/api/users", 
		method = RequestMethod.POST,
		consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
		produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> saveUser(@RequestBody User user){
	
		User savedUser = userService.save(user);
	
	return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);		
	}

	@RequestMapping(
	        value = "/api/users/{id}",
	        method = RequestMethod.PUT,
	        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
	        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user){
	 
		User updatedUser = userService.update(user);
	    if (updatedUser == null) {
	        return new ResponseEntity<User>(
	                HttpStatus.NOT_MODIFIED);
	    }		 
	 return new ResponseEntity<User>(updatedUser, HttpStatus.OK);			 
	}

	@RequestMapping(
	        value = "/api/users/{id}",
	        method = RequestMethod.DELETE,
	        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
		
		userService.delete(id);	
	    return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}


}
