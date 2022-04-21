package com.dumbturtl3.airbnb.repository;

import com.dumbturtl3.airbnb.models.TenantReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantReviewRepository extends JpaRepository<TenantReview,Integer> {

}
