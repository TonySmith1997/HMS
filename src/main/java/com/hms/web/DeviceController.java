package com.hms.web;

import com.hms.entity.Device;
import com.hms.entity.EmployeeInfo;
import com.hms.entity.User;
import com.hms.service.DrugService;
import com.hms.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private DrugService drugService;

    @RequestMapping(value = "/device/{id}",method = RequestMethod.GET)
    public @ResponseBody
    Device getDepartment(ModelMap map, @PathVariable String id) {
        Integer deviceId = Integer.valueOf(id);
        Device device = deviceService.get(deviceId);
//        List<EmployeeInfo> employeeInfos = employeeService.getEmployeeInfoByDepartment(departId);
//        for (EmployeeInfo employeeInfo: employeeInfos) {
//            int userId = employeeInfo.getUserId();
//            User user = userService.get(userId);
//            employeeInfo.setUser(user);
//        }
//        department.setEmployees(employeeInfos);
        return device;
    }
    @RequestMapping(value = "/update/{id}",method = GET)
    public @ResponseBody Device getDeviceForUpdate(@PathVariable String id) {
        Integer deviceId = Integer.valueOf(id);
        Device deviceInfo = deviceService.get(deviceId);
        return deviceInfo;
    }
}
