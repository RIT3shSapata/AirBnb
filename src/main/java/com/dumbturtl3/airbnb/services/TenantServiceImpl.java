package com.dumbturtl3.airbnb.services;

import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.ReviewFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.models.Tenant;
import com.dumbturtl3.airbnb.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantServiceImpl implements TenantService{

    @Autowired
    private TenantRepository tenantRepository;

    @Override
    public String singUp(SignUpFormData signUpFormData) {
        Integer id = tenantRepository.addTenant(signUpFormData);
        return Integer.toString(id);
    }

    @Override
    public Tenant findTenant(Integer id) {
        Tenant tenant = tenantRepository.findTenant(id);
        return tenant;
    }

    @Override
    public String login(LoginFormData loginFormData) {
        Integer id = tenantRepository.findByEmailAndPassword(loginFormData.getEmail(), loginFormData.getPassword());
        return Integer.toString(id);
    }

    @Override
    public void homeReview(ReviewFormData reviewFormData) {
        tenantRepository.homeReview(reviewFormData);
    }

}
