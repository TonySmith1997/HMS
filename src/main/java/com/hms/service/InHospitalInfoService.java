package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.InHospitalInfoDAO;
import com.hms.entity.InHospitalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InHospitalInfoService extends BaseService<InHospitalInfo,Integer>{
    @Autowired
    private InHospitalInfoDAO dao;

    @Override
    public BaseDAOImpl<InHospitalInfo, Integer> getBaseDAO() {
        return dao;
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public List<InHospitalInfo> getPatientInfo(int wardNum){
        String propertyName = "wardNum";
        return dao.findAllEq(propertyName,wardNum);
    }
}
