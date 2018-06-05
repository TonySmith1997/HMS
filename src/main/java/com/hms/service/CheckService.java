package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.CheckDAO;
import com.hms.entity.PhysicalExamination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CheckService extends BaseService<PhysicalExamination,Integer>{
    @Autowired
    private CheckDAO checkDAO;
    @Override
    public BaseDAOImpl<PhysicalExamination, Integer> getBaseDAO() {
        return checkDAO;
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public List<PhysicalExamination> getCheckByPatient(int patientId) {
        String propertyName =  "patientId";
        return checkDAO.findAllEq(propertyName,patientId);
    }
}
