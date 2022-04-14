package com.dumbturtl3.airbnb.services;

import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.models.User;

import javax.security.auth.message.AuthException;

public interface UserService {
    public String signUp(SignUpFormData signUpFormData);
    public User findUser(Integer id);
    public String login(LoginFormData loginFormData);
}
