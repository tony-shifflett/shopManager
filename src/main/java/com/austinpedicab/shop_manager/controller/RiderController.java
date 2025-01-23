package com.austinpedicab.shop_manager.controller;


import com.austinpedicab.shop_manager.database.dao.MaintenanceRequestDAO;
import com.austinpedicab.shop_manager.database.dao.PedicabDAO;
import com.austinpedicab.shop_manager.database.dao.RiderDAO;
import com.austinpedicab.shop_manager.database.dao.UserDAO;
import com.austinpedicab.shop_manager.database.entity.MaintenanceRequest;
import com.austinpedicab.shop_manager.database.entity.Rider;
import com.austinpedicab.shop_manager.database.entity.User;
import com.austinpedicab.shop_manager.form.SignupFormBean;
import com.austinpedicab.shop_manager.form.maintenance.MaintenanceRequestFormBean;
import com.austinpedicab.shop_manager.form.rider.AddRiderDetailsFormBean;
import com.austinpedicab.shop_manager.security.AuthenticatedUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
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
import java.time.LocalDateTime;
import java.util.List;


@Controller
@PreAuthorize("hasAuthority('RIDER')")
public class RiderController {

    @Autowired
    private RiderDAO riderDao;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private MaintenanceRequestDAO maintenanceRequestDao;

    @Autowired
    private PedicabDAO pedicabDao;

    @GetMapping("/rider/dashboard")
    public ModelAndView manageUsers(){
        ModelAndView response = new ModelAndView();
        response.setViewName("rider/riderDashboard");
        return response;
    }

    @GetMapping("/rider/update")
    public ModelAndView updateRider(){
        ModelAndView response = new ModelAndView();
        response.setViewName("rider/updateRider");
        return response;
    }

    @PostMapping("/rider/updateSubmit")
    public ModelAndView signupSubmit(@Valid AddRiderDetailsFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            response.setViewName("rider/update");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        } else{
            Rider rider = riderDao.findById(form.getId());
            rider.setFirstName(form.getFirstName());
            rider.setLastName(form.getLastName());
            rider.setPreferredName(form.getPreferredName());
            riderDao.save(rider);
            response.setViewName("redirect:/rider/dashboard");
        }
        return response;
    }

    @GetMapping("/rider/maintenanceRequest")
    public ModelAndView maintenanceRequest(){
        ModelAndView response = new ModelAndView();
        response.setViewName("rider/CreateMaintenanceRequest");
        return response;
    }

    @PostMapping("/rider/maintenanceSubmit")
    public ModelAndView maintanenceSubmit(@Valid MaintenanceRequestFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            response.setViewName("rider/CreateMaintenanceRequest");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        } else{
            MaintenanceRequest maintenanceRequest = new MaintenanceRequest();
            maintenanceRequest.setDateOpened(LocalDateTime.now());
            maintenanceRequest.setRider(riderDao.findById(form.getRiderId()));
            maintenanceRequest.setPedicab(pedicabDao.findPedicabByPedicabNumber(form.getPedicabNumber()));
            maintenanceRequest.setDetails(form.getDetails());
            maintenanceRequestDao.save(maintenanceRequest);
            response.setViewName("redirect:/rider/dashboard");
        }
        return response;
    }
//    @GetMapping("/rider/update")
//    public ModelAndView updateRider() {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("/rider/updateRider");
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        String username = authentication.getName();
////        User currentUser = userDao.findByEmailIgnoreCase(username);
////        Rider rider = riderDao.findById(currentUser.getId());
////        response.addObject("rider", rider);
//
//        return response;
//    }



}

