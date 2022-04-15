package com.dumbturtl3.airbnb.repository;

import com.dumbturtl3.airbnb.models.Owner;
import com.dumbturtl3.airbnb.models.SignUpFormData;
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
public class OwnerRepositoryImpl implements OwnerRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer addOwner(SignUpFormData signUpFormData) {
        final String SQL_ADD_OWNER = "INSERT INTO OWNER(OWNERID, FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,PHONENUMBER)" +
                "VALUES (NEXTVAL('OWNER_SEQ'),?,?,?,?,?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->{
            PreparedStatement ps = connection.prepareStatement(SQL_ADD_OWNER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,signUpFormData.getFirstName());
            ps.setString(2,signUpFormData.getLastName());
            ps.setString(3,signUpFormData.getEmail());
            ps.setString(4,signUpFormData.getPassword());
            ps.setString(5,signUpFormData.getPhone());
            return ps;
        },keyHolder);
        return (Integer) keyHolder.getKeys().get("OWNERID");
    }

    @Override
    public Owner findOwner(Integer id) {
        final String SQL_FIND_OWNER = "SELECT * FROM OWNER WHERE OWNERID="+Integer.toString(id)+";";
        List<Owner> owners = jdbcTemplate.query(SQL_FIND_OWNER,ownerRowMapper);
        return owners.get(0);
    }

    @Override
    public Integer findByEmailAndPassword(String email, String password) {
        final String SQL_FIND_TENANT_BY_EMAIL_PASSWORD = "SELECT * FROM OWNER WHERE EMAIL = '"+email+"' ;";
        List<Owner> owners = jdbcTemplate.query(SQL_FIND_TENANT_BY_EMAIL_PASSWORD,ownerRowMapper);
        return owners.get(0).getUserId();
    }
    private RowMapper<Owner> ownerRowMapper=((rs, rno)->{
        return new Owner(
                rs.getInt("OWNERID"),
                rs.getString("FIRST_NAME"),
                rs.getString("LAST_NAME"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD"),
                rs.getString("PHONENUMBER")
        );
    });
}
