package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.DepartementDAO;
import com.hms.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;


import java.util.List;

@Service
public class DepartmentService extends BaseService<Department,Integer>{
    @Autowired
    private DepartementDAO dao;
    public BaseDAOImpl<Department, Integer> getBaseDAO() {
        return dao;
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public Department getDepartmentUnique(int id)
    {
        String property = "id";
        return dao.findUniqueBy("id",id);
    }

}
