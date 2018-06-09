package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.RoleresourceDAO;
import com.hms.entity.Resources;
import com.hms.entity.RoleResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RoleResourceService extends BaseService<RoleResources,Integer>{
    @Autowired
    private RoleresourceDAO dao;
    @Override
    public BaseDAOImpl<RoleResources, Integer> getBaseDAO() {
        return dao;
    }

    @Transactional
    public List<RoleResources> findResourcesByRole(int roleId) {
        String properyName = "roleId";
        return dao.findAllEq(properyName,roleId);
    }

}
