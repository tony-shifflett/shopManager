package com.austinpedicab.shop_manager.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "riders")
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Integer id;

    @Column( name = "rider_firstname")
    private String firstName;

    @Column( name = "rider_lastname")
    private String lastName;

    @Column (name = "phone")
    private String phone;

//    FINISH IMPLEMENTATION AFTER DETERMINING ALL TABLE COLUMNS
    @Override
    public String toString() {
        return "Rider";
    }
}
