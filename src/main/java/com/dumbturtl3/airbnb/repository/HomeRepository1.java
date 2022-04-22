package com.dumbturtl3.airbnb.repository;

import com.dumbturtl3.airbnb.models.Home;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeRepository1 extends JpaRepository<Home,Integer> {
    List<Home> findByCity(String City);
}
