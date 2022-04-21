package com.dumbturtl3.airbnb.services;

import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.ReviewFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.models.Tenant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TenantService {
    public String singUp(SignUpFormData signUpFormData);
    public Tenant findTenant(Integer id);
    public String login(LoginFormData loginFormData);
<<<<<<< Updated upstream
    public void homeReview(ReviewFormData reviewFormData);
=======
    public void homeReview(HomeReviewFormData homeReviewFormData, Integer tenantID, Integer homeID);
    public Home getRoom(Integer id);
    public List<HomeReview> findReview(Integer id);
>>>>>>> Stashed changes
}
