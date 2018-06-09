package com.hms.web;

import com.hms.entity.*;
import com.hms.entity.logs.PatientLog;
import com.hms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
        int wardCount=wardService.count();
        Date LastUpdate = patientService.getLastUpdate();
        map.addAttribute("lastUpdate",LastUpdate);
        map.addAttribute("patientCount",count);
        map.addAttribute("wardcount",wardCount);
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
    //modify
@RequestMapping(value = "/update/{id}",method = GET)
public @ResponseBody PatientInfo getPatientForUpdate(@PathVariable String id) {
    Integer userId = Integer.valueOf(id);
    PatientInfo patientInfo = patientService.getPatientInfo(userId);
    User user = userService.get(userId);
    patientInfo.setUser(user);
    return patientInfo;
}

    /**
     *
     * @param userid
     * @param username
     * @param mobile
     * @param email
     * @param age
     * @param gender
     * @return
     */
    @RequestMapping(value = "update",method=POST)
    public String registerNewEmployee(
            @RequestParam("userid") String userid,
            @RequestParam("username") String username,
            @RequestParam("mobile") String mobile,
            @RequestParam("email") String email,
            @RequestParam("age") String age,
            @RequestParam("gender") String gender)
    {
        int userId = Integer.valueOf(userid.trim());
        User user = userService.get(userId);
        user.setTrueName(username.trim());
        user.setMobile(mobile.trim());
        user.setEmail(email.trim());
        user.setAge(Integer.valueOf(age.trim()));
        boolean gender1 = Boolean.valueOf(gender);
        user.setGender(gender1);
        user.setUpdateBy(1);
        Date date = new Date();
        user.setUpdateTime(date);
        userService.update(user);
        return "PatientList";
    }
}
