package com.dumbturtl3.airbnb.controllers;

import com.dumbturtl3.airbnb.models.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface TenantControllerInterface{
    public ModelAndView login();
    public ModelAndView signup();
    public ModelAndView dashboard(HttpSession session);
    public ModelAndView homeReview(Integer homeID);
    public ModelAndView viewRoom(Integer homeID);
    public ModelAndView viewRoomReview(Integer homeID);
    public String loginTenant(LoginFormData loginFormData, HttpServletRequest request);
    public String createTenant(Tenant tenant, HttpServletRequest request);
    public String addHomeReview( HomeReviewFormData homeReviewFormData, HttpSession session );
    public String bookRoom();
    public String searchRoom(SearchByCity city);
    public ModelAndView searchResults(SearchByCity city,HttpSession session);
}
