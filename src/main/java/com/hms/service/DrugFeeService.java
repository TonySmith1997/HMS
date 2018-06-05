package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.DrugFeeDAO;
import com.hms.entity.DrugFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DrugFeeService extends BaseService<DrugFee,Integer>{
    @Autowired
    private DrugFeeDAO drugFeeDAO;

    @Override
    public BaseDAOImpl<DrugFee, Integer> getBaseDAO() {
        return drugFeeDAO;
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public List<DrugFee> getDrugFeeByPatient(int patientId) {
        String propertyName =  "patientId";
        return drugFeeDAO.findAllEq(propertyName,patientId);
    }
}
