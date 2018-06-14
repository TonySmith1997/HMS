package com.hms.web;

import com.hms.entity.BloodBank;

import com.hms.service.BloodbankService;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;




@Controller
@RequestMapping("/bloodbank")
public class BloodbankController {
    @Autowired
    private BloodbankService BloodbankService;
    protected Logger log = LogManager.getLogger(BloodbankController.class);
    /**
     *
     * value->ajax.data
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public @ResponseBody
    BloodBank getBloodBankDetail(@PathVariable String id) {
        Integer bloodbankId = Integer.valueOf(id);
        BloodBank bloodbankInfo = BloodbankService.get(bloodbankId);
        return bloodbankInfo;
    }
}


//    /**
//     *update device
//     * @param deviceid
//     * @param devicename
//
//     * @return
//     */
//    @RequestMapping(value = "update",method=POST)
//    public String updateDevice(
//            @RequestParam("bloodtype") String bloodtype,
//            @RequestParam("qty") String qty,
//
//    {
//        int bloodBankId = Integer.valueOf(id.trim());
//        Device device = deviceService.get(deviceId);
//        device.setDeviceName(devicename.trim());
//        device.setLocation(location.trim());
//
//        device.setUpdateBy(1);
//        Date date = new Date();
//        device.setUpdateTime(date);
//        deviceService.update(device);
//        return "drugLog";
//    }
//
//    @RequestMapping(value="insert",method = POST)
//    public String insertdevice(
//            @RequestParam("devicename")String devicename,
//            @RequestParam("devicedescription")String devicedescription,
//            @RequestParam("location")String location,
//            @RequestParam("deviceunitPrice")String deviceunitPrice,
//            @RequestParam("deviceqty")String deviceqty)
//    {
//        Device device=new Device();
//        device.setAvator("static/img/a1.jpg");
//        device.setDeviceName(devicename.trim());
//        device.setLocation(location.trim());
//        device.setDescription(devicedescription.trim());
//        device.setQty(Integer.valueOf(deviceqty.trim()));
//        BigDecimal up=new BigDecimal(deviceunitPrice);
//        device.setUnitPrice(up);
//        device.setUpdateBy(1);
//        Date time=new Date();
//        device.setUpdateTime(time);
//        deviceService.save(device);
//        return "drugLog";
//    }
//    //    ajax ->device modify.data
//    @RequestMapping(value = "update/{id}",method = GET)
//    public @ResponseBody Device getDeviceForUpdate(@PathVariable String id) {
//        Integer deviceId = Integer.valueOf(id);
//        Device deviceInfo = deviceService.get(deviceId);
//        return deviceInfo;
//    }
//    @RequestMapping(value = "/search/{searchName}",method = RequestMethod.GET)
//    public @ResponseBody
//    List<Device> getDevicelike(@PathVariable String searchName) {
//        List<Device> devices = deviceService.getDeviceLike(searchName.trim()+"%");
//        return devices;
//    }
//
//}
