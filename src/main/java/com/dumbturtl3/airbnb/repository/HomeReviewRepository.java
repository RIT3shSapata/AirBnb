package com.dumbturtl3.airbnb.repository;

import com.dumbturtl3.airbnb.models.HomeReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeReviewRepository extends JpaRepository<HomeReview,Integer> {
}
