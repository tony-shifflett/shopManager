package com.austinpedicab.shop_manager.controller;


import com.austinpedicab.shop_manager.database.dao.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDao;
    
}
