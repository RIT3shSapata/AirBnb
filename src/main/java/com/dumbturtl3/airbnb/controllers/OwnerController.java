package com.dumbturtl3.airbnb.controllers;

import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.Owner;
import com.dumbturtl3.airbnb.models.TenantReviewFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/owner")
public class OwnerController implements OwnerControllerInterface{

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
    public ModelAndView dashboard( HttpSession session) {
        ModelAndView mav = new ModelAndView("ownerDashboard");
        String id = (String) session.getAttribute("OWNER_ID");
        Owner owner = ownerService.findOwner(Integer.parseInt(id));
        mav.addObject("owner",owner);
        return mav;
    }
    @GetMapping("/tenantReview")
    public ModelAndView tenantReview(){
        ModelAndView mav = new ModelAndView("tenantReview");
        TenantReviewFormData tenantReviewFormData = new TenantReviewFormData();
        mav.addObject("tenantReviewFormData", tenantReviewFormData);
        return mav;
    }

    @PostMapping(value = "/loginOwner")
    @Override
    public String loginUser(@ModelAttribute LoginFormData loginFormData, HttpServletRequest request) {
        String id = ownerService.login(loginFormData);
        request.getSession().setAttribute("OWNER_ID",id);
        return "redirect:/owner/dashboard";
    }

    @PostMapping("/createOwner")
    @Override
    public String createUser(@ModelAttribute SignUpFormData signUpFormData, HttpServletRequest request) {
        String id = ownerService.singUp(signUpFormData);
        request.getSession().setAttribute("OWNER_ID",id);
        return "redirect:/owner/dashboard";
    }

    @Override
    @PostMapping("/addTenantReview")
    public String addTenantReview(@ModelAttribute TenantReviewFormData tenantReviewFormData){
        ownerService.tenantReview(tenantReviewFormData);
        return "redirect:/owner/dashboard";
    }
}
