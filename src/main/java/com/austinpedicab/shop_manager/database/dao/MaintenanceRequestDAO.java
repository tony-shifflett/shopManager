package com.austinpedicab.shop_manager.database.dao;

import com.austinpedicab.shop_manager.database.entity.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRequestDAO extends JpaRepository<MaintenanceRequest, Long> {

    @Query("SELECT m FROM MaintenanceRequest m WHERE m.dateClosed is null")
    List<MaintenanceRequest> findOpenMaintenanceRequests();

}
