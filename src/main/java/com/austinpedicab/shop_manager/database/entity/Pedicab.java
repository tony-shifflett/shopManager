package com.austinpedicab.shop_manager.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    //Join To Maintenance Request
    @OneToMany(mappedBy = "pedicab", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<MaintenanceRequest> maintenanceRequests;

    @Column( name = "style")
    private String style;

    @Column (name = "pedicab_number")
    private Integer pedicabNumber;

    @Column (name = "in_service")
    private Boolean inService;

    //    FINISH IMPLEMENTATION AFTER DETERMINING ALL TABLE COLUMNS
    @Override
    public String toString() {
        return "Pedicab";
    }

}
