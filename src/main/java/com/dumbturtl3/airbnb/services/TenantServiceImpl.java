package com.dumbturtl3.airbnb.services;

<<<<<<< Updated upstream
import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.ReviewFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.models.Tenant;
import com.dumbturtl3.airbnb.repository.TenantRepository;
=======
import com.dumbturtl3.airbnb.models.*;
import com.dumbturtl3.airbnb.repository.*;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantServiceImpl implements TenantService{

    @Autowired
    private TenantRepository tenantRepository;

<<<<<<< Updated upstream
=======
    @Autowired
    private TenantRepository1 tenantRepository1;

    @Autowired
    private HomeRepository homeRepository;
    @Autowired
    private HomeRepository1 homeRepository1;

    @Autowired
    private HomeReviewRepository homeReviewRepository;

>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======
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

>>>>>>> Stashed changes
    @Override
    public void homeReview(ReviewFormData reviewFormData) {
        tenantRepository.homeReview(reviewFormData);
    }

}
