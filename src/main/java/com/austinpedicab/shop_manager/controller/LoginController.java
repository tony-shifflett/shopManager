package com.austinpedicab.shop_manager.controller;


import com.austinpedicab.shop_manager.database.dao.UserDAO;
import com.austinpedicab.shop_manager.database.entity.User;
import com.austinpedicab.shop_manager.form.SignupFormBean;
import com.austinpedicab.shop_manager.security.AuthenticatedUserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/login")
    public ModelAndView LoginPage() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginPage");
        return response;
    }

    @GetMapping("/signup")
    public ModelAndView SignupPage() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/signup");
        return response;
    }


    @PostMapping("/signup/signupSubmit")
    public ModelAndView signupSubmit(@Valid SignupFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            response.setViewName("login/signup");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        } else{
            User user = new User();
            user.setEmail(form.getUsername());
            String encryptedPassword = passwordEncoder.encode(form.getPassword());
            user.setPassword(encryptedPassword);
            userDao.save(user);
            authenticatedUserService.changeLoggedInUsername(session, form.getUsername(), form.getPassword());
            response.setViewName("redirect:/");
        }
        return response;
    }


}
