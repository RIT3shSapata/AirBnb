package com.dumbturtl3.airbnb.services;

import com.dumbturtl3.airbnb.models.*;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {
    public String signUp(Owner owner);
    public Owner findOwner(String id);
    public String login(LoginFormData loginFormData);
    public void tenantReview(TenantReview tenantReview,Integer ownerID,Integer tenantID);
    public void addHome(Home home, String  id);
}
