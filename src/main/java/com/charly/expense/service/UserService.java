package com.charly.expense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charly.expense.error.UserNotFoundException;
import com.charly.expense.model.User;


public interface UserService {
	
	User addUser (User user);

	List<User> getUsers();
	
	User getAUser(Long id) throws UserNotFoundException;

	User updateUserById(Long id, User user) throws UserNotFoundException;
	
	String removeUser(Long id) throws UserNotFoundException;

}
