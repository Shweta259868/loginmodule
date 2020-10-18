package com.example.demo.service;

import com.example.demo.model.POCUser;

public interface UserService {
    void save(POCUser user);

    POCUser findByUsername(String username);
}
