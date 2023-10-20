package com.khan.etapi.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khan.etapi.entities.User;
import com.khan.etapi.entities.UserModel;
import com.khan.etapi.exceptions.ItemAlreadyExistsException;
import com.khan.etapi.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(UserModel user) {
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new ItemAlreadyExistsException("User is already registered with email: " + user.getEmail());
		}

	User newUser = new User();
	BeanUtils.copyProperties(user, newUser); //source object, destination object
	return userRepository.save(newUser);
	}


}
