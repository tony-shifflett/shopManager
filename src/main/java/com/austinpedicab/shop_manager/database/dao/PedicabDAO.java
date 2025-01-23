package com.austinpedicab.shop_manager.database.dao;

import com.austinpedicab.shop_manager.database.entity.Pedicab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedicabDAO extends JpaRepository<Pedicab, Long> {
    @Query("SELECT p FROM Pedicab p WHERE p.pedicabNumber = :pedicabNumber")
    Pedicab findPedicabByPedicabNumber(Integer pedicabNumber);
}
