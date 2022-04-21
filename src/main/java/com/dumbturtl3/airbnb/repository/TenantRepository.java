package com.dumbturtl3.airbnb.repository;

import com.dumbturtl3.airbnb.models.HomeReviewFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.models.Tenant;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository {
    Integer addTenant(SignUpFormData signUpFormData);

    Tenant findTenant(Integer id);

    Integer findByEmailAndPassword(String email, String password);

    void homeReview(HomeReviewFormData homeReviewFormData);
}
