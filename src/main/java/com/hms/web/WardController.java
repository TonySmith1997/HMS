package com.hms.web;

import com.hms.entity.*;
import com.hms.service.InHospitalInfoService;
import com.hms.service.PatientService;
import com.hms.service.UserService;
import com.hms.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping(value = "/ward")
@Controller
public class WardController {
    @Autowired
    private WardService wardService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private InHospitalInfoService inHospitalInfoService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody
    Ward getWard(ModelMap map, @PathVariable String id) {
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
}