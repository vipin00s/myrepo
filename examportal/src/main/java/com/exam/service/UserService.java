package com.exam.service;

import java.util.Set;


import com.exam.dto.UserDTO;
import com.exam.exception.UserAlreadyExistsException;
import com.exam.exception.UserNotFoundException;
import com.exam.model.User;
import com.exam.model.UserRole;


public interface UserService {
public User createUser(User user , Set<UserRole> userRole) throws UserAlreadyExistsException ;
public void deleteUser(long userId) ;
public UserDTO getUserById(long id) throws UserNotFoundException;
public void updateUser(Long userId, String email)throws UserNotFoundException;
public Set<User> getUsers();







}

