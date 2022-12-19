package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.Role;
import com.exam.model.User;

public interface RoleRepository extends JpaRepository<Role, Long> {

	

}
