package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.PatientDAO;
import com.hms.entity.PatientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PatientService extends BaseService<PatientInfo,Integer>{
    @Autowired
    private PatientDAO patientDAO;

    @Override
    public BaseDAOImpl getBaseDAO() {
        return patientDAO;
    }

    @Transactional
    public Date getLastUpdate() {
        String propertyName = "updateTime";
        List<PatientInfo> patientInfos =  patientDAO.findAll(propertyName,false);
        return patientInfos.get(0).getUpdateTime();
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public PatientInfo getPatientInfo(int userId){
        String propertyName = "userId";
        return patientDAO.findUniqueBy(propertyName,userId);
    }

}
