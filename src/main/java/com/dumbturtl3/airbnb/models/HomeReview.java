package com.dumbturtl3.airbnb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="homeReview")
public class HomeReview {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int homeReviewID;
    private int homeID;
    private int tenantID;
    private double rating;
    private String review;
}
