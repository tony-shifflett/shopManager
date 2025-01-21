package com.austinpedicab.shop_manager.database.dao;

import com.austinpedicab.shop_manager.database.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiderDAO extends JpaRepository<Rider, Long> {

    List<Rider> findAllOrderByPreferredName(String preferredName);

    List<Rider>findByPreferredName(String preferredName);

    Rider findById(Integer id);

}
