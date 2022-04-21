package com.dumbturtl3.airbnb.controllers;

import com.dumbturtl3.airbnb.models.*;
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
    public String addTenantReview(TenantReview tenantReview);
    public ModelAndView addHome();
    public String addHomeData(Home home, HttpSession session);
}
