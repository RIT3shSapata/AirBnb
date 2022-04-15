package com.dumbturtl3.airbnb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Owner {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
}
