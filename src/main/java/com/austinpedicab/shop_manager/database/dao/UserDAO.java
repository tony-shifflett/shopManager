package com.austinpedicab.shop_manager.database.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.austinpedicab.shop_manager.database.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository <User, Long> {
    User findById( Integer id);

    User findByEmailIgnoreCase( String email);

    @Query("SELECT u FROM User u WHERE NOT EXISTS (SELECT ur FROM UserRole ur WHERE ur.userId = u.id)")
    List<User> findPendingUsers();

}
