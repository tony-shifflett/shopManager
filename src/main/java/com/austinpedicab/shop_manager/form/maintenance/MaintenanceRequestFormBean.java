package com.austinpedicab.shop_manager.form.maintenance;

import com.austinpedicab.shop_manager.validation.EmailUnique;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MaintenanceRequestFormBean {

    @NotNull(message = "Rider ID is required.")
    private Integer riderId;

    @NotNull( message = "Pedicab number is required.")
    private Integer pedicabNumber;


    @NotEmpty(message="Description is required.")
    private String details;
}
