package com.austinpedicab.shop_manager.form;

import com.austinpedicab.shop_manager.validation.CurrentPasswordValid;
import com.austinpedicab.shop_manager.validation.EmailUnique;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupFormBean {
    @EmailUnique(message = "Username is already in use.")
    @NotEmpty( message = "Username is required.")
    private String username;


    @NotEmpty(message="Password is required.")
    private String password;
}
