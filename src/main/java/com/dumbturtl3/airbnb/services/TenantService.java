package com.dumbturtl3.airbnb.services;

import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.models.Tenant;
import org.springframework.stereotype.Service;

@Service
public interface TenantService {
    public String singUp(SignUpFormData signUpFormData);
    public Tenant findTenant(Integer id);
    public String login(LoginFormData loginFormData);
}
