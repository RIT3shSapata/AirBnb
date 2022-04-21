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
        Tenant tenant = new Tenant();
        mav.addObject("tenant",tenant);
        return mav;
    }

    @GetMapping("/dashboard")
    @Override
    public ModelAndView dashboard( HttpSession session){
        ModelAndView mav = new ModelAndView("tenantDashboard");
        String id = (String) session.getAttribute("TENANT_ID");
        Tenant tenant = tenantService.findTenant(id);
        mav.addObject("tenant",tenant);
        return mav;
    }

    @GetMapping("/homeReview")
    @Override
    public ModelAndView homeReview(@RequestParam Integer id){
        ModelAndView mav = new ModelAndView("homeReview");
        HomeReviewFormData homeReviewFormData = new HomeReviewFormData();
        homeReviewFormData.setHomeID(id);
        mav.addObject("reviewFormData", homeReviewFormData);
        return mav;
    }

    @Override
    public ModelAndView viewRoom(@RequestParam(value="id") Integer homeID){
       ModelAndView mav = new ModelAndView("roomDetails");
       BookRoomForm bookRoomForm = new BookRoomForm();
       Home home = tenantService.getRoom(homeID);
       mav.addObject("bookRoomForm", bookRoomForm);
       mav.addObject("home",home);
       return mav;
    }

    @PostMapping(value = "/loginTenant")
    @Override
    public String loginTenant(@ModelAttribute LoginFormData loginFormData, HttpServletRequest request){
        String id = tenantService.login(loginFormData);
        request.getSession().setAttribute("TENANT_ID",id);
        return "redirect:/tenant/dashboard";
    }

    @PostMapping("/createTenant")
    @Override
    public String createTenant(@ModelAttribute Tenant tenant, HttpServletRequest request){
        String id = tenantService.signUp(tenant);
        request.getSession().setAttribute("TENANT_ID",id);
        return "redirect:/tenant/dashboard";
    }

    @PostMapping("/homeReview")
    @Override
    public String addHomeReview(@ModelAttribute HomeReviewFormData homeReviewFormData,HttpSession session ){
        Integer tenantID =Integer.parseInt ((String) session.getAttribute("TENANT_ID"));
        tenantService.homeReview(homeReviewFormData,tenantID, homeReviewFormData.getHomeID());
        return "redirect:/tenant/dashboard";
    }

    @PostMapping("/bookRoom")
    @Override
    public String bookRoom() {
        return null;
    }
}
