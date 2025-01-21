package com.austinpedicab.shop_manager.validation.rider;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Pattern;

public class PhoneNumberValidImpl implements ConstraintValidator<PhoneNumberValid, String> {

    public static final Logger LOG = LoggerFactory.getLogger(PhoneNumberValidImpl.class);
    private static final String PHONE_NUMBER_REGEX = "^[0-9]{10}$";
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REGEX);

    @Override
    public void initialize(PhoneNumberValid constraintAnnotation) {}

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return true;
        }
        return PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches();
    }

}
