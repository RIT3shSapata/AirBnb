package com.dumbturtl3.airbnb.repository;

import com.dumbturtl3.airbnb.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository1 extends JpaRepository<Owner,Integer> {
    List<Owner> findByEmailAndPassword(String email, String password);
}
