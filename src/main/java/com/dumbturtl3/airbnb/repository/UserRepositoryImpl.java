package com.dumbturtl3.airbnb.repository;

import com.dumbturtl3.airbnb.exceptions.AuthException;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String SQL_ADD_USER = "INSERT INTO USERS(USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) " +
            "VALUES (NEXTVAL('USERS_SEQ'),?,?,?,?);";
    @Override
    public Integer addUser(SignUpFormData signUpFormData) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
       jdbcTemplate.update(connection->{
           PreparedStatement ps = connection.prepareStatement(SQL_ADD_USER, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1,signUpFormData.getFirstName());
           ps.setString(2,signUpFormData.getLastName());
           ps.setString(3,signUpFormData.getEmail());
           ps.setString(4,signUpFormData.getPassword());
           return ps;
       },keyHolder);
       return (Integer) keyHolder.getKeys().get("USER_ID");
    }

    @Override
    public User findUser(Integer id) {
        final String SQL_FIND_USER = "SELECT * FROM USERS WHERE USER_ID="+Integer.toString(id)+";";
        List<User> users = jdbcTemplate.query(SQL_FIND_USER,userRowMapper);
        return users.get(0);
    }

    @Override
    public Integer findByEmailAndPassword(String email, String password) throws AuthException {
        System.out.println(email+password);
        final String SQL_FIND_USER_BY_EMAIL_PASSWORD = "SELECT * FROM USERS WHERE EMAIL= '"+email+"' ;";
        List<User> users = jdbcTemplate.query(SQL_FIND_USER_BY_EMAIL_PASSWORD,userRowMapper);
        System.out.println(users);
        return users.get(0).getUserId();
    }

    private RowMapper<User> userRowMapper=((rs,rno)->{
        return new User(
                rs.getInt("USER_ID"),
                rs.getString("FIRST_NAME"),
                rs.getString("LAST_NAME"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD")
        );
    });
}
