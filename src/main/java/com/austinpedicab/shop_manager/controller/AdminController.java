package com.austinpedicab.shop_manager.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {
    @GetMapping("/admin/dashboard")
    public ModelAndView AdminDash(){
        ModelAndView response = new ModelAndView("admin");
        response.setViewName("admin/adminDashboard");
        return response;
    }

}
