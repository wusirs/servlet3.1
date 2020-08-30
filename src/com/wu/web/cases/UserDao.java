package com.wu.web.cases;

public class UserDao {
    private JDBCTemplate<User> temp = new JDBCTemplate<User>();
    public User login(User user){
        String sql = new StringBuilder()
                    .append(" select ")
                    .append("   username, password ")
                    .append(" from ")
                    .append("   user ")
                    .append(" where ")
                    .append("   username = ? ")
                    .toString();
        return temp.selectOne(sql, new UserMapper(), user.getUsername());
    }
}
