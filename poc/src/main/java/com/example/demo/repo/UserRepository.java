package com.example.demo.repo;

import com.example.demo.model.POCUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<POCUser, Long> {

    POCUser findByUsername(String username);
}
