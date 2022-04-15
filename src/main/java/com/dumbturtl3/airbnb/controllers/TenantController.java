package com.dumbturtl3.airbnb.controllers;

import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.models.Tenant;
import com.dumbturtl3.airbnb.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tenant")
public class TenantController implements UserController{

    @Autowired
    private TenantService tenantService;

    @GetMapping({"/","/login"})
    @Override
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("tenantLogin");
        LoginFormData loginFormData = new LoginFormData();
        mav.addObject("loginFormData",loginFormData);
        return mav;
    }

    @GetMapping("/signup")
    @Override
    public ModelAndView signup(){
        ModelAndView mav = new ModelAndView("tenantSignUp");
        SignUpFormData signUpFormData= new SignUpFormData();
        mav.addObject("signUpFromData",signUpFormData);
        return mav;
    }

    @GetMapping("/dashboard")
    @Override
    public ModelAndView dashboard(@RequestParam(value = "id") Integer id){
        ModelAndView mav = new ModelAndView("tenantDashboard");
        Tenant tenant = tenantService.findTenant(id);
        mav.addObject("tenant",tenant);
        return mav;
    }

    @PostMapping(value = "/loginTenant")
    @Override
    public String loginUser(@ModelAttribute LoginFormData loginFormData){
        String id = tenantService.login(loginFormData);
        return "redirect:/tenant/dashboard/?id="+id;
    }

    @PostMapping("/createTenant")
    @Override
    public String createUser(@ModelAttribute SignUpFormData signUpFormData){
        String id = tenantService.singUp(signUpFormData);
        return "redirect:/tenant/dashboard/?id="+id;
    }
}
