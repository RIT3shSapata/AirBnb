package com.dumbturtl3.airbnb.controllers;

import com.dumbturtl3.airbnb.models.HomeReviewFormData;
import org.springframework.web.servlet.ModelAndView;

public interface TenantControllerInterface extends UserController{
    public ModelAndView homeReview();
    public String addHomeReview(HomeReviewFormData homeReviewFormData);
    public ModelAndView viewRoom(Integer homeID);
    public String bookRoom();
}
