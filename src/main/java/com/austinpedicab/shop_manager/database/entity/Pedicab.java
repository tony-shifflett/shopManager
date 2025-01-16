package com.austinpedicab.shop_manager.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedicabs")
public class Pedicab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column( name = "style")
    private String style;

    @Column (name = "bike_number")
    private Integer bikeNumber;

    @Column (name = "in_service")
    private Boolean inService;

    //    FINISH IMPLEMENTATION AFTER DETERMINING ALL TABLE COLUMNS
    @Override
    public String toString() {
        return "Pedicab";
    }

}
