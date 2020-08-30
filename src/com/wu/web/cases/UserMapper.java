package com.wu.web.cases;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User getObject(ResultSet rs) {
        User user = new User();
        try {
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
