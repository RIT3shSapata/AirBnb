package com.dumbturtl3.airbnb.repository;

import com.dumbturtl3.airbnb.models.Home;
import com.dumbturtl3.airbnb.models.HomeFormData;

public interface HomeRepository {
    void addRoom(HomeFormData homeFormData);
    Home getRoom(Integer id);
}
