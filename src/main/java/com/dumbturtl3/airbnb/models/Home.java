package com.dumbturtl3.airbnb.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Home {
    private int homeID;
    private String homeName;
    private double price;
    private String city;
    private String state;
    private String country;
    private String pin;
    private int ownerID;
}
