package com.dumbturtl3.airbnb.services;

import com.dumbturtl3.airbnb.models.*;
import com.dumbturtl3.airbnb.repository.HomeRepository;
import com.dumbturtl3.airbnb.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private HomeRepository homeRepository;

    @Override
    public String singUp(SignUpFormData signUpFormData) {
        Integer id = ownerRepository.addOwner(signUpFormData);
        return Integer.toString(id);
    }

    @Override
    public Owner findOwner(Integer id) {
        Owner owner = ownerRepository.findOwner(id);
        return owner;
    }

    @Override
    public String login(LoginFormData loginFormData) {
        Integer id = ownerRepository.findByEmailAndPassword(loginFormData.getEmail(),loginFormData.getPassword());
        return Integer.toString(id);
    }

    public void tenantReview(TenantReviewFormData tenantReviewFormData){
        ownerRepository.addReview(tenantReviewFormData);
    }

    @Override
    public void addHome(HomeFormData homeFormData) {
//        ownerRepository.addRoom(homeFormData);
        homeRepository.addRoom(homeFormData);
    }
}
