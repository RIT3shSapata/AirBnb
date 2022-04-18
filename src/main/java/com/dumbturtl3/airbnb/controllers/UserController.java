package com.dumbturtl3.airbnb.controllers;

import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public interface UserController {
    public ModelAndView login();
    public ModelAndView signup();
    public ModelAndView dashboard(HttpSession session);
    public String loginUser(LoginFormData loginFormData, HttpServletRequest request);
    public String createUser(SignUpFormData signUpFormData, HttpServletRequest request);
}
