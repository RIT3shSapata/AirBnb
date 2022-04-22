package com.dumbturtl3.airbnb.services;

import com.dumbturtl3.airbnb.models.*;
import com.dumbturtl3.airbnb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService{

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private TenantRepository1 tenantRepository1;

    @Autowired
    private HomeRepository homeRepository;
    @Autowired
    private HomeRepository1 homeRepository1;

    @Autowired
    private HomeReviewRepository homeReviewRepository;

    @Override
    public String signUp(Tenant tenant) {
        Tenant obj = tenantRepository1.save(tenant);
        return Integer.toString(obj.getTenantID());
    }

    @Override
    public Tenant findTenant(String id) {
        return tenantRepository1.getById(Integer.parseInt(id));
    }

    @Override
    public String login(LoginFormData loginFormData) {
//        Integer id = tenantRepository.findByEmailAndPassword(loginFormData.getEmail(), loginFormData.getPassword());
        List<Tenant> tenants = tenantRepository1.findByEmailAndPassword(loginFormData.getEmail(),loginFormData.getPassword());
        int id = tenants.get(0).getTenantID();
        return Integer.toString(id);
    }

    //TODO: convert the old repository code to new repository
    @Override
    public void homeReview(HomeReviewFormData homeReviewFormData, Integer tenantID, Integer homeID) {
        HomeReview homeReview = new HomeReview();
        homeReview.setHomeID(homeID);
        homeReview.setTenantID(tenantID);
        homeReview.setRating(homeReviewFormData.getRating());
        homeReview.setReview(homeReviewFormData.getReview());
        homeReviewRepository.save(homeReview);
//        tenantRepository.homeReview(homeReviewFormData);
    }
    @Override
    public List<HomeReview> findReview(Integer id){
        List<HomeReview> homeReviews = homeReviewRepository.findByHomeID(id);
        return homeReviews;
    }


    @Override
    public Home getRoom(Integer id) {
        Home home = homeRepository.getRoom(id);
        return home;
    }

    @Override
    public List<Home> findHomes(String city) {
        List<Home> homes = homeRepository1.findByCity(city);
        return homes;
    }

}
