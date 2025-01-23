package com.austinpedicab.shop_manager.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class RedirectAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectUrl = "/index";

        if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
            redirectUrl = "/admin/dashboard";
        }
        else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("RIDER"))) {
            redirectUrl = "/rider/riderDashboard";
        }
        //FURTHER CUSTOM DASHBOARD: MECHANIC??
        response.sendRedirect(redirectUrl);
    }
}
