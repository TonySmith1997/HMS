package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.DeviceDAO;
import com.hms.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class DeviceService extends BaseService<Device,Integer> {
    @Autowired
    private DeviceDAO deviceDAO;
    public BaseDAOImpl<Device, Integer> getBaseDAO() {
        return deviceDAO;
    }
    @Transactional
    public Date getLastUpdate() {
        String propertyName = "updateTime";
        List<Device> deviceInfos =  deviceDAO.findAll(propertyName,false);
        return deviceInfos.get(0).getUpdateTime();
    }
    @Transactional
    public List<Device> getDeviceLike(String searchName) {
        return deviceDAO.findDevice(searchName);
    }

}
