package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.POCUser;
import com.example.demo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
   
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public void save(POCUser user) { 
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setTypeid(5);
        try {
           userRepository.save(user);
                 	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
    }

    
    public POCUser findByUsername(String username) {
      return userRepository.findByUsername(username);
    }
}
