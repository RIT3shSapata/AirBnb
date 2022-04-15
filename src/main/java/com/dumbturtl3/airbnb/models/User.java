package com.dumbturtl3.airbnb.models;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
}
