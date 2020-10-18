package com.example.demo.service;

import com.example.demo.util.CustomString;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, CustomString password);
}
