package com.dumbturtl3.airbnb.services;

import com.dumbturtl3.airbnb.models.*;
import org.springframework.stereotype.Service;

@Service
public interface TenantService {
    public String signUp(Tenant tenant);
    public Tenant findTenant(String id);
    public String login(LoginFormData loginFormData);
    public void homeReview(HomeReviewFormData homeReviewFormData, Integer tenantID, Integer homeID);
    public Home getRoom(Integer id);
}
