package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.POCUser;
import com.example.demo.model.Role;
import com.example.demo.repo.RoleRepository;
import com.example.demo.repo.UserRepository;
@Service
public class UserLoginService implements UserDetailsService {
	
	
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		  POCUser user = userRepository.findByUsername(username);
		  List<Role> roles=roleRepository.findByTypeid(5);

	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        for (Role role : roles){
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
	        User u = new User(user.getUsername(), user.getPassword(), true, true, true, true, grantedAuthorities);
			return u;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public RoleRepository getRoleRepository() {
		return roleRepository;
	}

	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	

	}
