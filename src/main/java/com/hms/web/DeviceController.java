package com.hms.web;

import com.hms.entity.Device;
import com.hms.entity.Drug;
import com.hms.service.DeviceService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    protected Logger log = LogManager.getLogger(DeviceController.class);
    /**
     *
     * value->ajax.data
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public @ResponseBody
    Device getDeviceDetail(@PathVariable String id) {
        Integer deviceId = Integer.valueOf(id);
        Device deviceInfo = deviceService.get(deviceId);
        return deviceInfo;
    }

    /**
     *update device
     * @param deviceid
     * @param devicename
     * @param location
     * @param devicedescription
     * @param deviceqty
     * @param deviceunitprice
     * @return
     */
    @RequestMapping(value = "update",method=POST)
    public String updateDevice(
            @RequestParam("deviceid") String deviceid,
            @RequestParam("devicename") String devicename,
            @RequestParam("location") String location,
            @RequestParam("devicedescription") String devicedescription,
            @RequestParam("deviceqty") String deviceqty,
            @RequestParam("deviceunitprice") String deviceunitprice)
    {
        int deviceId = Integer.valueOf(deviceid.trim());
        Device device = deviceService.get(deviceId);
        device.setDeviceName(devicename.trim());
        device.setLocation(location.trim());
        //DeviceInfo deviceInfo = deviceService.getdeviceInfo(deviceId);
        //deviceInfo.set(newLocationId);
        device.setDescription(devicedescription.trim());
        device.setQty(Integer.valueOf(deviceqty.trim()));
        BigDecimal up=new BigDecimal(deviceunitprice);
        device.setUnitPrice(up);
        device.setUpdateBy(1);
        Date date = new Date();
        device.setUpdateTime(date);
        deviceService.update(device);
        return "drugLog";
    }

    @RequestMapping(value="insert",method = POST)
    public String insertdevice(
         @RequestParam("devicename")String devicename,
         @RequestParam("devicedescription")String devicedescription,
         @RequestParam("location")String location,
         @RequestParam("deviceunitPrice")String deviceunitPrice,
         @RequestParam("deviceqty")String deviceqty)
    {
        Device device=new Device();
        device.setAvator("static/img/a1.jpg");
        device.setDeviceName(devicename.trim());
        device.setLocation(location.trim());
        device.setDescription(devicedescription.trim());
        device.setQty(Integer.valueOf(deviceqty.trim()));
        BigDecimal up=new BigDecimal(deviceunitPrice);
        device.setUnitPrice(up);
        device.setUpdateBy(1);
        Date time=new Date();
        device.setUpdateTime(time);
        deviceService.save(device);
        return "drugLog";
    }
//    ajax ->device modify.data
    @RequestMapping(value = "update/{id}",method = GET)
    public @ResponseBody Device getDeviceForUpdate(@PathVariable String id) {
        Integer deviceId = Integer.valueOf(id);
        Device deviceInfo = deviceService.get(deviceId);
        return deviceInfo;
    }
    @RequestMapping(value = "/search/{searchName}",method = RequestMethod.GET)
    public @ResponseBody
    List<Device> getDevicelike(@PathVariable String searchName) {
        List<Device> devices = deviceService.getDeviceLike(searchName.trim()+"%");
        return devices;
    }

}
