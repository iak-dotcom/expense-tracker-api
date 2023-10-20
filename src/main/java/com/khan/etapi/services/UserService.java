package com.khan.etapi.services;

import com.khan.etapi.entities.User;
import com.khan.etapi.entities.UserModel;

public interface UserService {
	User createUser(UserModel user);
	
	User readUser(Long id);
	
	User updateUser(UserModel user,Long id);
}
