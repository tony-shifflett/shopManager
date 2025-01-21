package com.austinpedicab.shop_manager.form.rider;

import com.austinpedicab.shop_manager.validation.rider.PhoneNumberValid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class AddRiderDetailsFormBean {

    private Integer id;

    @NotEmpty(message = "First Name Required")
    @Length(max = 20, message = "Your first name cannot exceed 20 characters")
    private String firstName;

    @NotEmpty(message = "Last Name Required")
    @Length(max = 50, message = "Last Name Cannot Exceed 20 Characters")
    private String lastName;

    @NotEmpty(message = "Preferred Name Required")
    @Length(max = 20, message = "Preferred Name Cannot Exceed 20 Characters ")
    private String preferredName;

    @NotEmpty(message = "Phone Number Required")
    @PhoneNumberValid
    private String phone;

}
