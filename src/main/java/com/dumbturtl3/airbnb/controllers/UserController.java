package com.dumbturtl3.airbnb.controllers;

import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public interface UserController {
    public ModelAndView login();
    public ModelAndView signup();
    public ModelAndView dashboard(Integer id);
    public String loginUser(LoginFormData loginFormData);
    public String createUser(SignUpFormData signUpFormData);
}
