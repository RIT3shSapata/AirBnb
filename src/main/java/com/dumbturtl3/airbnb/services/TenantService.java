package com.dumbturtl3.airbnb.services;

import com.dumbturtl3.airbnb.models.*;
import org.springframework.stereotype.Service;

@Service
public interface TenantService {
    public String singUp(SignUpFormData signUpFormData);
    public Tenant findTenant(Integer id);
    public String login(LoginFormData loginFormData);
    public void homeReview(HomeReviewFormData homeReviewFormData);
}
