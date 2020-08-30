package com.wu.web.cases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate<T> {
    public List<T> selectAll(String sql, RowMapper<T> mapper , Object... params) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<T> result = new ArrayList<T>();
        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i ++){
                pst.setObject((i + 1) , params[i]);
            }
            rs = pst.executeQuery();
            while (rs.next()){
                result.add(mapper.getObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            JDBCUtil.close(rs, pst, null);
        }
        return result;
    }

    public T selectOne(String sql, RowMapper<T> mapper , Object... params){
        List<T> result = selectAll(sql, mapper, params);
        return result.size() == 0 ? null : result.get(0);
    }
}
