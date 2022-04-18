package com.dumbturtl3.airbnb.services;

import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.Owner;
import com.dumbturtl3.airbnb.models.ReviewFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {
    public String singUp(SignUpFormData signUpFormData);
    public Owner findOwner(Integer id);
    public String login(LoginFormData loginFormData);
    public void tenantReview(ReviewFormData reviewFormData);
}
