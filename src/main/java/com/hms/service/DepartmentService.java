package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.DepartementDAO;
import com.hms.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
        return dao.findUniqueBy(property,id);
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public Department getDepartmentByName(String departmentName)
    {
        String property = "departName";
        return dao.findUniqueBy(property,departmentName);
    }

    @Transactional
    public List<Department> findDepartmentLike(String searchName) {
        return dao.findDepartmentLike(searchName);
    }
}
