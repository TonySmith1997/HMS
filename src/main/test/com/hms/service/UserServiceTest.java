package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.UserDAO;
import com.hms.entity.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserServiceTest {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void save(){
        String userid = "1";
        String username = "PY";
        String mobile = "13958932001";
        String email = "504277122@qq.com";
        String age = "20";
        String gender = "male";
        int userId = Integer.valueOf(userid.trim());
        User user = userService.get(userId);
        user.setUsername(username.trim());
        user.setMobile(mobile.trim());
        user.setEmail(email.trim());
        user.setAge(Integer.valueOf(age.trim()));
        user.setGender(gender == "male" ? true : false);
        user.setUpdateBy(1);
        Date date = new Date();
        user.setUpdateTime(date);
        userService.update(user);
    }

    @Test
    public void find(){
        int id = 1;
        User user = userService.get(id);
        System.out.println(user);
    }


}
