package com.dumbturtl3.airbnb.services;

import com.dumbturtl3.airbnb.models.LoginFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.models.User;
import com.dumbturtl3.airbnb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String signUp(SignUpFormData signUpFormData) {
        Integer id = userRepository.addUser(signUpFormData);
        return Integer.toString(id);
    }

    @Override
    public User findUser(Integer id) {
        User user = userRepository.findUser(id);
        return user;
    }

    @Override
    public String login(LoginFormData loginFormData) {
        Integer id = userRepository.findByEmailAndPassword(loginFormData.getEmail(), loginFormData.getPassword());
        return Integer.toString(id);
    }
}
