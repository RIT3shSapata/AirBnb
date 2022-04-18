package com.dumbturtl3.airbnb.controllers;

import org.springframework.web.servlet.ModelAndView;

public interface TenantControllerInterface extends UserController{
    public ModelAndView homeReview();
}
