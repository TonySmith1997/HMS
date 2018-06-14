package com.hms.web;

import com.hms.entity.*;
import com.hms.service.InHospitalInfoService;
import com.hms.service.PatientService;
import com.hms.service.UserService;
import com.hms.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping(value = "/ward")
@Controller
public class WardController {
    @Autowired
    private WardService wardService;
    @Autowired
    private InHospitalInfoService inHospitalInfoService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "{id}", method = GET)
    public @ResponseBody
    Ward getWard( @PathVariable String id) {
        Integer wardId = Integer.valueOf(id);
        Ward ward = wardService.get(wardId);
        List<InHospitalInfo> inHospitalInfos = inHospitalInfoService.getPatientInfo(wardId);
        for (InHospitalInfo inHospitalInfo : inHospitalInfos) {
            int userId = inHospitalInfo.getUserId();
            User user = userService.get(userId);
            inHospitalInfo.setUser(user);
        }
        ward.setPatientInfos(inHospitalInfos);
        return ward;
    }

    @RequestMapping(value = "available",method = GET)
    public @ResponseBody
    List<Ward> getAvailableWard(){
        return wardService.getAvailableWard();
    }
}