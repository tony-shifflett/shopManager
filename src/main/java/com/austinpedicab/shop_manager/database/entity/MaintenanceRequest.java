package com.austinpedicab.shop_manager.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maintenance_requests")
public class MaintenanceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //JOIN TO PEDICAB
    //JOIN TO RIDER

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "date_resolved")
    private LocalDateTime dateResolved;

    @Column(name = "description")
    private String description;
}
