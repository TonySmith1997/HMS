package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.DeviceDAO;
import com.hms.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DeviceService extends BaseService<Device,Integer> {
    @Autowired
    private DeviceDAO deviceDAO;
    public BaseDAOImpl<Device, Integer> getBaseDAO() {
        return deviceDAO;
    }
}
