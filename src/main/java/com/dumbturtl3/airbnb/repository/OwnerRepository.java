package com.dumbturtl3.airbnb.repository;

import com.dumbturtl3.airbnb.models.Owner;
import com.dumbturtl3.airbnb.models.TenantReviewFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;

public interface OwnerRepository {

    Integer addOwner(SignUpFormData signUpFormData);

    Owner findOwner(Integer id);

    Integer findByEmailAndPassword(String email, String password);
    void addReview(TenantReviewFormData tenantReviewFormData);

}
