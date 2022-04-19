package com.dumbturtl3.airbnb.repository;

import com.dumbturtl3.airbnb.models.Home;
import com.dumbturtl3.airbnb.models.HomeFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class HomeRepositoryImpl implements HomeRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addRoom(HomeFormData homeFormData) {

        final String SQL_ADD_ROOM = "INSERT INTO home(homeid, ownerid,homename,price, city,state,country,pin)\n" +
                "VALUES (NEXTVAL('HOME_SEQ'), ?, ?, ?,?,?,?,?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->{
            PreparedStatement ps = connection.prepareStatement(SQL_ADD_ROOM, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, homeFormData.getOwnerID());
            ps.setString(2, homeFormData.getHomeName());
            ps.setDouble(3, homeFormData.getPrice());
            ps.setString(4, homeFormData.getCity());
            ps.setString(5, homeFormData.getState());
            ps.setString(6, homeFormData.getCountry());
            ps.setString(7, homeFormData.getPin());
            return ps;
        },keyHolder);
    }

    @Override
    public Home getRoom(Integer id){
//        final String SQL_FIND_HOME="select home.homeid,home.homename,home.price,home.city,home.state,home.country,home.pin,o.ownerid from home inner join owner o on home.ownerid = o.ownerid";
        final String SQL_FIND_HOME="select * from home where homeid="+Integer.toString(id)+";";
        List<Home> homes= jdbcTemplate.query(SQL_FIND_HOME,homeRowMapper);
        return homes.get(0);
    }

    final private RowMapper<Home> homeRowMapper = ((rs,rno)->{
        return new Home(
                rs.getInt("HOMEID"),
                rs.getString("HOMENAME"),
                rs.getDouble("PRICE"),
                rs.getString("CITY"),
                rs.getString("COUNTRY"),
                rs.getString("STATE"),
                rs.getString("PIN"),
                rs.getInt("HOME.OWNERID")
        );
    });
}
