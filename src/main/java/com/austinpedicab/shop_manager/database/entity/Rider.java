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

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column( name = "first_name")
    private String firstName;

    @Column( name = "last_name")
    private String lastName;

    @Column(name = "isCurrentRider", columnDefinition = "TINYINT")
    private Boolean isCurrentRider;

    @Column (name = "preferred_name")
    private String preferredName;

    @Column (name = "phone")
    private String phone;

//    FINISH IMPLEMENTATION AFTER DETERMINING ALL TABLE COLUMNS
    @Override
    public String toString() {
        return "Rider";
    }
}
