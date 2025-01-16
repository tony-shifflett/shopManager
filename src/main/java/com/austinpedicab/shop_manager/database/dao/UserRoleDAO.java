package com.austinpedicab.shop_manager.database.dao;

import com.austinpedicab.shop_manager.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
    UserRole findById(long id);
    UserRole findByUserId(Long userId);
}
