package com.exam.service;

import java.util.LinkedHashSet;
import java.util.Optional;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dto.UserDTO;
import com.exam.exception.UserAlreadyExistsException;
import com.exam.exception.UserNotFoundException;
import com.exam.model.Category;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

@Autowired
private UserRepository userRepository;

@Autowired
private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws UserAlreadyExistsException {
   User local=this.userRepository.findByUserName(user.getUsername());
	if(local!=null) {
		throw new UserAlreadyExistsException();
	}else {
		for(UserRole ur:userRoles) {		
		roleRepository.save(ur.getRole());
	}
	user.getUserRole().addAll(userRoles);
	local=this.userRepository.save(user);
	}
	return local;
	}
	
	@Override
	public UserDTO getUserById(long id) throws UserNotFoundException {

		Optional<User> optional=userRepository.findById(id) ;
		User user= optional.orElseThrow(()-> new UserNotFoundException());
		UserDTO user2=new UserDTO();
		user2.setUsername(user.getUsername());
		user2.setFirstName(user.getFirstName());
		user2.setLastName(user.getLastName());
			user2.setPassword(user.getPassword());
			user2.setEmail(user.getEmail());
			user2.setId(user.getId());
			user2.setProfile(user.getProfile());
			user2.setPhone(user.getPhone());
			return user2;
		
	}
	
	@Override
	public void deleteUser(long userId) {
		this.userRepository.deleteById(userId);
		
		
	}
	@Override
	public void updateUser(Long userId, String emailId  ) throws UserNotFoundException {
		if(userRepository.existsById(userId)) {
       User user = userRepository.findById(userId).get();
       user.setEmail(emailId);
      userRepository.save(user);
   	}
		else {
			throw new UserNotFoundException();
		}
	}
	
@Override
public Set<User> getUsers() {
	return  new LinkedHashSet<>(this.userRepository.findAll());
}
}

