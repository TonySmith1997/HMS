package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.BloodBankDAO;
import com.hms.entity.BloodBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BloodbankService extends BaseService<BloodBank,Integer> {
    @Autowired
    private BloodBankDAO bloodbankDAO;
    public BaseDAOImpl<BloodBank, Integer> getBaseDAO() {
        return bloodbankDAO;
    }
    @Transactional
    public Date getLastUpdate() {
        String propertyName = "updateTime";
        List<BloodBank> bloodBanksInfos =  bloodbankDAO.findAll(propertyName,false);
        return bloodBanksInfos.get(0).getUpdateTime();
    }
    @Transactional
    public List<BloodBank> getbloodBankLike(String searchName) {
        return bloodbankDAO.findBloodBank(searchName);
    }

    @Transactional
    public BloodBank getbloodBankByName(String type) {
        String property = "bloodType";
        return bloodbankDAO.findUniqueBy(property,type);
    }
}