package com.dumbturtl3.airbnb.repository;

import com.dumbturtl3.airbnb.models.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantRepository1 extends JpaRepository<Tenant, Integer> {
    List<Tenant> findByEmailAndPassword(String email, String password);
}

