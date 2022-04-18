package com.dumbturtl3.airbnb.controllers;

import com.dumbturtl3.airbnb.models.HomeFormData;
import com.dumbturtl3.airbnb.models.TenantReviewFormData;
import org.springframework.web.servlet.ModelAndView;

public interface OwnerControllerInterface extends UserController {
    public ModelAndView tenantReview();
    public String addTenantReview(TenantReviewFormData tenantReviewFormData);
    public ModelAndView addHome();
    public String addHomeData(HomeFormData homeFormData);
}
