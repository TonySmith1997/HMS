package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.UserRoleDAO;
import com.hms.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServive extends BaseService<UserRole,Integer>{
    @Autowired
    private UserRoleDAO dao;
    @Override
    public BaseDAOImpl<UserRole, Integer> getBaseDAO() {
        return dao;
    }

}
