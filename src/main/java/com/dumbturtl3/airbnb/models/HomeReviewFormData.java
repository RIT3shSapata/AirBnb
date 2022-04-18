package com.dumbturtl3.airbnb.models;

import lombok.Data;

@Data
public class HomeReviewFormData {

    private int homeID;
    private int ownerID;
    private int tenantID;
    private float rating;
    private String review;
}
