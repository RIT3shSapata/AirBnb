package com.dumbturtl3.airbnb.controllers;

import com.dumbturtl3.airbnb.models.HomeFormData;
import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.Owner;
import com.dumbturtl3.airbnb.models.TenantReviewFormData;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface OwnerControllerInterface {
    public ModelAndView login();
    public ModelAndView signup();
    public ModelAndView dashboard(HttpSession session);
    public String loginOwner(LoginFormData loginFormData, HttpServletRequest request);
    public ModelAndView tenantReview();
    public String createOwner(Owner owner, HttpServletRequest request);
    public String addTenantReview(TenantReviewFormData tenantReviewFormData);
    public ModelAndView addHome();
    public String addHomeData(HomeFormData homeFormData, HttpSession session);
}
