package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.WardDAO;
import com.hms.entity.Ward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WardService extends BaseService<Ward,Integer>{
    @Autowired
    private WardDAO wardDAO;
    @Override
    public BaseDAOImpl<Ward, Integer> getBaseDAO() {
        return wardDAO;
    }

    @Transactional
    public List<Ward> getAvailableWard() {
        List<Ward> wards = wardDAO.findAll();
        for(Ward ward : wards) {
            if(ward.getTotalNum() == ward.getNum()) {
                wards.remove(ward);
            }
        }
        return wards;
    }

    @Transactional
    public Ward getWardByLocation(String location){
        String property = "location";
        return wardDAO.findUniqueBy(property,location);
    }
}
