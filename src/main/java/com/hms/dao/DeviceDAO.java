package com.hms.dao;

import com.hms.core.base.BaseDAOImpl;
import com.hms.entity.Device;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeviceDAO extends BaseDAOImpl<Device,Integer> {
    public Criterion findDeviceLike(String searchName) {
        return findlike("deviceName",searchName);
    }

    public List<Device> findDevice(String searchName) {
        Criterion c1 = findDeviceLike(searchName);
        return createCriteria(c1).list();
    }
}
