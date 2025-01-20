package com.austinpedicab.shop_manager.form;

import com.austinpedicab.shop_manager.validation.EmailUnique;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupFormBean {
    @EmailUnique(message = "Username is already in use.")
    @NotEmpty( message = "Username is required.")
    private String username;
}
