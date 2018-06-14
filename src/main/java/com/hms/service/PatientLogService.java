package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.PatientLogDAO;
import com.hms.entity.logs.PatientLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PatientLogService extends BaseService<PatientLog,Integer>{
    @Autowired
    private PatientLogDAO dao;
    @Override
    public BaseDAOImpl<PatientLog, Integer> getBaseDAO() {
        return dao;
    }
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public List<PatientLog> getPatientLog(int who){
        String propertyName = "patientId";
        return dao.findAllEq(propertyName,who);
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void savePatientLog(int patientId,
                                int employeeId,
                                String patientName,
                                String employeeName,
                                String type,
                                Date date){
        PatientLog log = new PatientLog();
        log.setWhen(date);
        log.setType(type);
        log.setPatientId(patientId);
        log.setWhat(patientName + " was " + type + " by " + employeeName + " at " + date);
        dao.save(log);
    }
}
