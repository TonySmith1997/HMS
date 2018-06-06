package com.hms.web;

import com.hms.entity.InHospitalInfo;
import com.hms.entity.PatientInfo;
import com.hms.entity.User;
import com.hms.entity.Ward;
import com.hms.entity.logs.PatientLog;
import com.hms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    UserService userService;
    @Autowired
    PatientService patientService;
    @Autowired
    WardService wardService;
    @Autowired
    PatientLogService patientLogService;
    @Autowired
    InHospitalInfoService inHospitalInfoService;


    @RequestMapping(value = "",method = GET)
    public String getTotalList(ModelMap map){
        List<User> patients = userService.getPatientList();
        List<Ward> wards = wardService.getAll();
        int count = patientService.count();
        Date LastUpdate = patientService.getLastUpdate();
        map.addAttribute("lastUpdate",LastUpdate);
        map.addAttribute("patientCount",count);
        map.addAttribute("patients",patients);
        map.addAttribute("wards",wards);
        return "PatientList";
    }

    /**
     * 获得用户详情
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public @ResponseBody
    PatientInfo getEmployeeDetail(@PathVariable String id) {
        Integer userId = Integer.valueOf(id);
        PatientInfo patientInfo = patientService.getPatientInfo(userId);
        User user = userService.get(userId);
        List<PatientLog> patientLogs = patientLogService.getPatientLog(userId);
        patientInfo.setUser(user);
        patientInfo.setPatientLogs(patientLogs);
        if(patientInfo.isInpatient() == true) {
            int inHospitalId = patientInfo.getInHospitalId();
            InHospitalInfo inHospitalInfo = inHospitalInfoService.get(inHospitalId);
            patientInfo.setInHospitalInfo(inHospitalInfo);
            Ward ward = wardService.get(inHospitalInfo.getWardNum());
            patientInfo.setWard(ward);
        }
        return patientInfo;
    }



    /**
     * 搜索
     * @param searchName
     * @return
     */
    @RequestMapping(value = "/search/{searchName}",method = RequestMethod.GET)
    public @ResponseBody
    List<User> getEmployeeLike(@PathVariable String searchName) {
        List<User> users = userService.getPatientLike(searchName.trim()+"%");
        return users;
    }

}
