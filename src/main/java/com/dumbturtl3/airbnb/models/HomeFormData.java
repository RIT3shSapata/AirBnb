package com.dumbturtl3.airbnb.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@NoArgsConstructor
@Getter
public class HomeFormData {
    private String homeName;
    private int ownerID;
    private double price;
    private String city;
    private String state;
    private String country;
    private String pin;
}
