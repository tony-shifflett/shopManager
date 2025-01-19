package com.austinpedicab.shop_manager.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "batteries")
public class Battery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batteries")
    private Integer batteries;

    @Column(name="amps")
    private Integer amps;

    //JOIN TO RiDER
}
