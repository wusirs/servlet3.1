package com.wu.web.cases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        User user = new User("张三","123");
        UserDao ud = new UserDao();
        User login = ud.login(user);
        System.out.println(login);
        JDBCUtil.close(null, null, null);
    }
}
