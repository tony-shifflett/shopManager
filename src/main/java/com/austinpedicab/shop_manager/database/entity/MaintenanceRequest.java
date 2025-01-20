package com.austinpedicab.shop_manager.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maintenance_request")
public class MaintenanceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //JOIN TO PEDICAB
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedicab")
    @EqualsAndHashCode.Exclude
    private Pedicab pedicab;

    //JOIN TO RIDER
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rider")
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Rider rider;

    @Column(name = "date_opened")
    private LocalDateTime dateOpened;

    @Column(name = "date_closed")
    private LocalDateTime dateClosed;

    @Column(name = "description")
    private String description;

}
