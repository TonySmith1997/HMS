package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.UserRoleDAO;
import com.hms.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRoleService extends BaseService<UserRole,Integer>{
    @Autowired
    private UserRoleDAO dao;
    @Override
    public BaseDAOImpl<UserRole, Integer> getBaseDAO() {
        return dao;
    }
    @Transactional
    public List<UserRole> findResourcesByRole(int userId) {
        String properyName = "userId";
        return dao.findAllEq(properyName,userId);
    }
}
