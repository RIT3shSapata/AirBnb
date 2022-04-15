package com.dumbturtl3.airbnb.models;

import lombok.*;

@ToString
@Setter
@NoArgsConstructor
@Getter
public class LoginFormData {
    private String email;
    private String password;
}
