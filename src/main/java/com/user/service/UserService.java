package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	public UserRepository userRepository;
	
	public User getUser(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public List<User> getAllUsers(){
		return (List<User>) userRepository.findAll();
	}
	
	public boolean addUser(User user) {
		return userRepository.save(user) != null;
	}
	
	public boolean updateUser(int id,User user) {
		User u=userRepository.findById(id).orElse(null);
		if(u!=null) {
			u.id=user.getId();
			u.name=user.getName();
			u.organization=user.getOrganization();
			userRepository.save(u);
			return true;
		}else {
			return false;
		}
		
	}
	
	public void deleteUser(int id) {
		 userRepository.deleteById(id);
	}
	
}
