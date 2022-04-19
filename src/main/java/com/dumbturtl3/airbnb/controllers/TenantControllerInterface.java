package com.dumbturtl3.airbnb.controllers;

import com.dumbturtl3.airbnb.models.HomeReviewFormData;
import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.models.Tenant;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface TenantControllerInterface{
    public ModelAndView login();
    public ModelAndView signup();
    public ModelAndView dashboard(HttpSession session);
    public ModelAndView homeReview();
    public ModelAndView viewRoom(Integer homeID);
    public String loginTenant(LoginFormData loginFormData, HttpServletRequest request);
    public String createTenant(Tenant tenant, HttpServletRequest request);
    public String addHomeReview(HomeReviewFormData homeReviewFormData);
    public String bookRoom();
}
