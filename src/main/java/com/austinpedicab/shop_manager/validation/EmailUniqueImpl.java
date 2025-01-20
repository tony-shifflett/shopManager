package com.austinpedicab.shop_manager.validation;

import com.austinpedicab.shop_manager.database.dao.UserDAO;
import com.austinpedicab.shop_manager.database.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmailUniqueImpl implements ConstraintValidator<EmailUnique, String> {

    public static final Logger LOG = LoggerFactory.getLogger(EmailUniqueImpl.class);

    @Autowired
    private UserDAO userService;

    @Override
    public void initialize(EmailUnique constraintAnnotation){}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)){
            return true;
        }
        User user = userService.findByEmailIgnoreCase(value);
        return (user == null);
    }


}
