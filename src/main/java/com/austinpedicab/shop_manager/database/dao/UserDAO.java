package com.austinpedicab.shop_manager.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.austinpedicab.shop_manager.database.entity.User;

public interface UserDAO extends JpaRepository <User, Long> {
    User findById( Integer id);
    User findByEmailIgnoreCase( String email);

}
