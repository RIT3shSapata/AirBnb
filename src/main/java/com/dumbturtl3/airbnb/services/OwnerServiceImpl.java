package com.dumbturtl3.airbnb.services;

import com.dumbturtl3.airbnb.models.*;
import com.dumbturtl3.airbnb.repository.HomeRepository;
import com.dumbturtl3.airbnb.repository.OwnerRepository;
import com.dumbturtl3.airbnb.repository.OwnerRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private OwnerRepository1 ownerRepository1;
    @Autowired
    private HomeRepository homeRepository;

    @Override
    public String signUp(Owner owner) {
        Owner obj = ownerRepository1.save(owner);
        return Integer.toString(obj.getOwnerID());
    }

    @Override
    public Owner findOwner(String id) {
        return ownerRepository1.getById(Integer.parseInt(id));
    }

    @Override
    public String login(LoginFormData loginFormData) {
        List<Owner> owners = ownerRepository1.findByEmailAndPassword(loginFormData.getEmail(), loginFormData.getPassword());
        int id = owners.get(0).getOwnerID();
        return Integer.toString(id);
    }

    //TODO: Change code from old owner repository to new owner repository
    public void tenantReview(TenantReviewFormData tenantReviewFormData){
        ownerRepository.addReview(tenantReviewFormData);
    }

    @Override
    public void addHome(HomeFormData homeFormData) {
//        ownerRepository.addRoom(homeFormData);
        homeRepository.addRoom(homeFormData);
    }
}
