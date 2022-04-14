package com.dumbturtl3.airbnb.models;

import lombok.*;

@ToString
@Setter
@NoArgsConstructor
@Getter
public class LoginFormData {
    public String email;
    public String password;
}
