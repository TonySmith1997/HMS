package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.EmployeeDAO;
import com.hms.entity.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService extends BaseService<EmployeeInfo,Integer>{

    @Autowired
    protected EmployeeDAO employeeDAO;

    public BaseDAOImpl<EmployeeInfo, Integer> getBaseDAO() {
        return employeeDAO;
    }

    public EmployeeInfo getEmployeeInfo(int userId){
        String propertyName = "userId";
        return employeeDAO.findUniqueBy(propertyName,userId);
    }
}
