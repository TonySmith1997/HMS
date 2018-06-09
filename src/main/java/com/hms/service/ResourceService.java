package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.ResourceDAO;
import com.hms.entity.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService extends BaseService<Resources,Integer>{
    @Autowired
    private ResourceDAO resourceDAO;

    @Override
    public BaseDAOImpl<Resources, Integer> getBaseDAO() {
        return resourceDAO;
    }
}
