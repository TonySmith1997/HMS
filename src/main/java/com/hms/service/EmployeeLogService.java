package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.EmployeeLogDAO;
import com.hms.entity.logs.EmployeeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeLogService extends BaseService<EmployeeLog,Integer>{

    @Autowired
    private EmployeeLogDAO dao;

    public BaseDAOImpl<EmployeeLog, Integer> getBaseDAO() {
        return dao;
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public List<EmployeeLog> getEmployeeLog(int who){
        String propertyName = "who";
        return dao.findAllEq(propertyName,who);
    }
}
