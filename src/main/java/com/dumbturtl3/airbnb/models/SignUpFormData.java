package com.dumbturtl3.airbnb.models;

import lombok.Data;

@Data
public class SignUpFormData {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
}
