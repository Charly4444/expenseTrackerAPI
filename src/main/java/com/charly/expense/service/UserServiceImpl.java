package com.charly.expense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charly.expense.error.UserNotFoundException;
import com.charly.expense.model.User;
import com.charly.expense.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		User newUser = new User();
		newUser.setId(user.getId());
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
		userRepository.save(newUser);
		return newUser;
		
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getAUser(Long id) throws UserNotFoundException{
		if (userRepository.findById(id).isEmpty()) {
			throw new UserNotFoundException("User Not Found!!");
		}
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUserById(Long id, User user) throws UserNotFoundException{
		if (userRepository.findById(id).isEmpty()) {
			throw new UserNotFoundException("User Not Found!!");
		}
		User upUser = userRepository.findById(id).get();
		upUser.setEmail(user.getEmail());
		upUser.setName(user.getName());
		userRepository.save(upUser);
		return upUser;
	}
	
	@Override
	public String removeUser(Long id) throws UserNotFoundException{
		if (userRepository.findById(id).isEmpty()) {
			throw new UserNotFoundException("User Not Found!!");
		}
		userRepository.deleteById(id);
		return "user has been deleted !!";
	}

}
