package com.wu.web.case4_loginVerify;

import com.wu.web.cases.User;
import com.wu.web.cases.UserDao;

public class UserService {
    UserDao userDao = new UserDao();
    public void login(User user) throws Exception {
        User loginUser = userDao.login(user);
        if (loginUser == null){
            throw new Exception("用户不存在");
        }

        if (!loginUser.getPassword().equals(user.getPassword())){
            throw new Exception("用户名和密码不匹配");
        }
    }
}
