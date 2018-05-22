package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.EmployeeLogDAO;
import com.hms.entity.logs.EmployeeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeLogService extends BaseService<EmployeeLog,Integer>{

    @Autowired
    private EmployeeLogDAO dao;

    public BaseDAOImpl<EmployeeLog, Integer> getBaseDAO() {
        return dao;
    }

    public List<EmployeeLog> getEmployeeLog(int userId){
        String propertyName = "userId";
        return dao.findAllEq(propertyName,"userId");
    }
}
