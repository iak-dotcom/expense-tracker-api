package com.khan.etapi.services;

import com.khan.etapi.entities.User;
import com.khan.etapi.entities.UserModel;

public interface UserService {
	User createUser(UserModel user);
	
	User readUser();
	
	User updateUser(UserModel user);
	
	void deleteUser();
	
	User getLoggedInUser();
}
