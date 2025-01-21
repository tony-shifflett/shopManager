package com.austinpedicab.shop_manager.controller;


import com.austinpedicab.shop_manager.database.dao.RiderDAO;
import com.austinpedicab.shop_manager.database.dao.UserDAO;
import com.austinpedicab.shop_manager.database.entity.Rider;
import com.austinpedicab.shop_manager.database.entity.User;
import com.austinpedicab.shop_manager.security.AuthenticatedUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


@Controller
@PreAuthorize("hasAuthority('RIDER')")
public class RiderController {

    @Autowired
    private RiderDAO riderDao;

    @Autowired
    private UserDAO userDao;

    @GetMapping("/rider")
    public ModelAndView riderDash() {
        ModelAndView response = new ModelAndView();
        response.setViewName("/rider/riderDashboard");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userDao.findByEmailIgnoreCase(username);
        Rider rider = riderDao.findById(currentUser.getId());
        response.addObject("rider", rider);

        return response;
    }



}

