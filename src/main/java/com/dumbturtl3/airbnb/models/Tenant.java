package com.dumbturtl3.airbnb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tenant {
    private Integer userId;
    private   String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
}
