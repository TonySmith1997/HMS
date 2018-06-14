package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.BloodDonerDAO;
import com.hms.entity.BloodDonor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BlooddonorService extends BaseService<BloodDonor,Integer> {
    @Autowired
    private BloodDonerDAO blooddonorDAO;
    public BaseDAOImpl<BloodDonor,Integer> getBaseDAO() {
        return blooddonorDAO;
    }

    @Transactional
    public Date getLastUpdate() {
        String propertyName = "updateTime";
        List<BloodDonor> blooddonorInfos = blooddonorDAO.findAll(propertyName,false);
        return blooddonorInfos.get(0).getUpdateTime();
    }
    @Transactional
    public List<BloodDonor> getBloodDonorLike(String searchName) {
        return blooddonorDAO.findBlooddonor(searchName);
    }
    @Transactional
    public BloodDonor getBloodDonorByMobile(String mobile) {
        String property = "mobile";
        return blooddonorDAO.findUniqueBy(property,mobile);
    }
}