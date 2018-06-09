package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.RoleDAO;
import com.hms.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseService<Role,Integer>{
    @Autowired
    private RoleDAO dao;

    @Override
    public BaseDAOImpl<Role, Integer> getBaseDAO() {
        return dao;
    }
}
