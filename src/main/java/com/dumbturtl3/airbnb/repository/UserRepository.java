package com.dumbturtl3.airbnb.repository;

import com.dumbturtl3.airbnb.exceptions.AuthException;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.models.User;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface UserRepository {

    Integer addUser(SignUpFormData signUpFormData);

    User findUser(Integer id);

    Integer findByEmailAndPassword(String email,String password);
}
