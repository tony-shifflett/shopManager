package com.austinpedicab.shop_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping(value = {"/index/"})
    public ModelAndView index() {
        ModelAndView response = new ModelAndView();
        response.setViewName("index");
        return response;
    }
}
