package com.dumbturtl3.airbnb.models;

import lombok.*;

import java.sql.Date;

@ToString
@Setter
@NoArgsConstructor
@Getter
public class BookRoomForm {
    private int homeID;
    private int ownerID;
    private int tenantID;
    private Date startDate;
    private Date endDate;
    private String status;
}
