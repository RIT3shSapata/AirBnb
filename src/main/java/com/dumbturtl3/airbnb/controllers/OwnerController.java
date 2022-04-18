package com.dumbturtl3.airbnb.controllers;

import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.Owner;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owner")
public class OwnerController implements UserController{

    @Autowired
    private OwnerService ownerService;

    @GetMapping({"/","/login"})
    @Override
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("ownerLogin");
        LoginFormData loginFormData = new LoginFormData();
        mav.addObject("loginFormData",loginFormData);
        return mav;
    }

    @GetMapping("/signup")
    @Override
    public ModelAndView signup() {
        ModelAndView mav = new ModelAndView("ownerSignUp");
        SignUpFormData signUpFormData= new SignUpFormData();
        mav.addObject("signUpFromData",signUpFormData);
        return mav;
    }

    @GetMapping("/dashboard")
    @Override
    public ModelAndView dashboard(@RequestParam(value = "id") Integer id) {
        ModelAndView mav = new ModelAndView("ownerDashboard");
        Owner owner = ownerService.findOwner(id);
        mav.addObject("owner",owner);
        return mav;
    }

    @PostMapping(value = "/loginOwner")
    @Override
    public String loginUser(@ModelAttribute LoginFormData loginFormData) {
        String id = ownerService.login(loginFormData);
        return "redirect:/owner/dashboard/?id="+id;
    }

    @PostMapping("/createOwner")
    @Override
    public String createUser(@ModelAttribute SignUpFormData signUpFormData) {
        String id = ownerService.singUp(signUpFormData);
        return "redirect:/owner/dashboard/?id=" + id;
    }

}
