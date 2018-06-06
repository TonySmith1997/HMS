package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.WardDAO;
import com.hms.entity.Ward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WardService extends BaseService<Ward,Integer>{
    @Autowired
    private WardDAO wardDAO;
    @Override
    public BaseDAOImpl<Ward, Integer> getBaseDAO() {
        return wardDAO;
    }
}
