package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.EmployeeLogDAO;
import com.hms.entity.EmployeeInfo;
import com.hms.entity.logs.EmployeeLog;
import com.hms.type.LogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void saveEmployeeLog(int who,String name,String type,Date date){
        EmployeeLog log = new EmployeeLog();
        log.setWhen(date);
        log.setType(type);
        log.setWho(who);
        System.out.println(who);
        log.setWhat(type + " at " + date + ", by "+ name);
        dao.save(log);
    }



}
