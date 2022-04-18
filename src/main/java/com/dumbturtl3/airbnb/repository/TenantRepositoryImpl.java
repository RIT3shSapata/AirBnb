package com.dumbturtl3.airbnb.repository;

import com.dumbturtl3.airbnb.models.HomeReviewFormData;
import com.dumbturtl3.airbnb.models.TenantReviewFormData;
import com.dumbturtl3.airbnb.models.SignUpFormData;
import com.dumbturtl3.airbnb.models.Tenant;
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
public class TenantRepositoryImpl implements TenantRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer addTenant(SignUpFormData signUpFormData) {
        final String SQL_ADD_TENANT = "INSERT INTO TENANT(TENANTID, FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,PHONENUMBER)" +
                "VALUES (NEXTVAL('TENANT_SEQ'),?,?,?,?,?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->{
            PreparedStatement ps = connection.prepareStatement(SQL_ADD_TENANT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,signUpFormData.getFirstName());
            ps.setString(2,signUpFormData.getLastName());
            ps.setString(3,signUpFormData.getEmail());
            ps.setString(4,signUpFormData.getPassword());
            ps.setString(5,signUpFormData.getPhone());
            return ps;
        },keyHolder);
        return (Integer) keyHolder.getKeys().get("TENANTID");
    }

    @Override
    public Tenant findTenant(Integer id) {
        final String SQL_FIND_TENANT = "SELECT * FROM TENANT WHERE TENANTID="+Integer.toString(id)+";";
        List<Tenant> tenants = jdbcTemplate.query(SQL_FIND_TENANT,tenantRowMapper);
        return tenants.get(0);
    }

    @Override
    public Integer findByEmailAndPassword(String email, String password) {
        final String SQL_FIND_TENANT_BY_EMAIL_PASSWORD = "SELECT * FROM TENANT WHERE EMAIL = '"+email+"' ;";
        List<Tenant> tenants = jdbcTemplate.query(SQL_FIND_TENANT_BY_EMAIL_PASSWORD,tenantRowMapper);
        return tenants.get(0).getUserId();
    }

    public void homeReview(HomeReviewFormData homeReviewFormData){
        final String SQL_ADD_REVIEW = "INSERT INTO HOMEREVIEW(HOMEID,OWNERID,TENANTID,RATING,REVIEW)"+ "VALUES(NEXTVAL('TENANT_SEQ'),?,?,?,?,?);" ;       KeyHolder keyHolder = new GeneratedKeyHolder();
        KeyHolder reviewkey = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->{
            PreparedStatement ps = connection.prepareStatement(SQL_ADD_REVIEW, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, homeReviewFormData.getHomeID());
            ps.setInt(2, homeReviewFormData.getOwnerID());
            ps.setInt(3, homeReviewFormData.getTenantID());
            ps.setFloat(4, homeReviewFormData.getRating());
            ps.setString(5, homeReviewFormData.getReview());
            return ps;
        },reviewkey);

    }

    private RowMapper<Tenant> tenantRowMapper=((rs,rno)->{
        return new Tenant(
                rs.getInt("TENANTID"),
                rs.getString("FIRST_NAME"),
                rs.getString("LAST_NAME"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD"),
                rs.getString("PHONENUMBER")
        );
    });
}
