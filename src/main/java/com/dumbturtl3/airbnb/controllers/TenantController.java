package com.dumbturtl3.airbnb.controllers;

import com.dumbturtl3.airbnb.models.*;
import com.dumbturtl3.airbnb.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/tenant")
public class TenantController implements TenantControllerInterface{

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
    @GetMapping("/homeReview")
    @Override
    public ModelAndView homeReview(){
        ModelAndView mav = new ModelAndView("homeReview");
        HomeReviewFormData homeReviewFormData = new HomeReviewFormData();
        mav.addObject("reviewFormData", homeReviewFormData);
        return mav;
    }

    @GetMapping("/dashboard")
    @Override
    public ModelAndView dashboard( HttpSession session){
        ModelAndView mav = new ModelAndView("tenantDashboard");
        String id = (String) session.getAttribute("TENANT_ID");
        Tenant tenant = tenantService.findTenant(Integer.parseInt(id));
        SearchByCity searchByCity=new SearchByCity();
        mav.addObject("searchByCity",searchByCity);
        mav.addObject("tenant",tenant);
        return mav;
    }
    @Override
    @GetMapping("/searchResults")
    public ModelAndView searchResults() {
        return null;
    }
    @PostMapping(value = "/loginTenant")
    @Override
    public String loginUser(@ModelAttribute LoginFormData loginFormData, HttpServletRequest request){
        String id = tenantService.login(loginFormData);
        request.getSession().setAttribute("TENANT_ID",id);
        return "redirect:/tenant/dashboard";
    }

    @PostMapping("/createTenant")
    @Override
    public String createUser(@ModelAttribute SignUpFormData signUpFormData, HttpServletRequest request){
        String id = tenantService.singUp(signUpFormData);
        request.getSession().setAttribute("TENANT_ID",id);
        return "redirect:/tenant/dashboard";
    }

    @PostMapping("/homeReview")
    @Override
    public String addHomeReview(@ModelAttribute HomeReviewFormData homeReviewFormData){
        tenantService.homeReview(homeReviewFormData);
        return "redirect:/tenant/dashboard";
    }


    @PostMapping("/searchRoom")
    @Override
    public String searchRoom() {
        return null;
    }



}
