package com.dumbturtl3.airbnb.controllers;

import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.models.User;
import com.dumbturtl3.airbnb.services.UserService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"/","/login"})
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        LoginFormData loginFormData = new LoginFormData();
        mav.addObject("loginFormData",loginFormData);
        return mav;
    }

    @GetMapping("/signup")
    public ModelAndView signup(){
        ModelAndView mav = new ModelAndView("signup");
        SignUpFormData signUpFormData = new SignUpFormData();
        mav.addObject("signUpFromData",signUpFormData);
        return mav;
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard(@RequestParam(value = "id") Integer id){
        ModelAndView mav = new ModelAndView("dashboard");
        User user = userService.findUser(id);
        System.out.println(user);
        mav.addObject("user",user);
        return mav;
    }

    @PostMapping(value = "/loginUser",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String loginUser(@ModelAttribute LoginFormData loginFormData){
        System.out.println(loginFormData);
        String id = userService.login(loginFormData);
        return "redirect:/dashboard/?id="+id;
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute SignUpFormData signUpFormData){
        String id = userService.signUp(signUpFormData);
        return "redirect:/dashboard/?id="+id;
    }
}
