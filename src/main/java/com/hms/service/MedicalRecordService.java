package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.MedicalRecordDAO;
import com.hms.entity.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class MedicalRecordService extends BaseService<MedicalRecord,Integer>{

    @Autowired
    private MedicalRecordDAO dao;

    @Override
    public BaseDAOImpl<MedicalRecord, Integer> getBaseDAO() {
        return dao;
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public MedicalRecord getRecordByUserId(int patientId) {
        String propertyName = "patientId";
        return dao.findUniqueBy(propertyName,patientId);
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public List<MedicalRecord> getAllRecord() {
        return dao.findAll();
    }
}
