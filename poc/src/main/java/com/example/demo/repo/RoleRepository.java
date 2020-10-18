package com.example.demo.repo;

import com.example.demo.model.Role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	List<Role> findByTypeid(Integer typeid);
	
}
