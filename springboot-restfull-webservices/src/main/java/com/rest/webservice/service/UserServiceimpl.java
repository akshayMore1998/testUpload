package com.rest.webservice.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rest.webservice.entity.User;
import com.rest.webservice.repo.UserRepository;

@Service
public class UserServiceimpl  implements UserService{

	
	private UserRepository userRepository; 
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		Optional<User> opUser = userRepository.findById(userId);
		return opUser.get();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastname(user.getLastname());
		existingUser.setEmail(user.getEmail());
		User updateUsr = userRepository.save(existingUser);
		
		return updateUsr;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}

}
