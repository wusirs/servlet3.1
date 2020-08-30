package com.wu.web.cases;

import java.sql.ResultSet;

public interface RowMapper <T>{
    public T getObject(ResultSet rs);
}
