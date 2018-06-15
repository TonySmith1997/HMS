package com.hms.web;

import com.hms.core.util.WebUtil;
import com.hms.entity.*;
import com.hms.entity.logs.PatientLog;
import com.hms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    @Autowired
    MedicalRecordService medicalRecordService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    MessageService messageService;
    @Autowired
    UserRoleService userRoleService;


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
     * 用户list
     * @param map
     * @return
     */
    @Transactional
    @RequestMapping(value= "/list",method = RequestMethod.GET)
    public @ResponseBody List<User> getPatientList(ModelMap map) {
        return userService.getPatientList();
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
     * 病人更新
     * @param userid
     * @param username
     * @param mobile
     * @param email
     * @param age
     * @param gender
     * @return
     */
    @RequestMapping(value = "update",method=POST)
    public String updateNewPatient(
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

    /**
     * 病人注册页面跳转
     * @return
     */
    @RequestMapping(value = "register",method = GET)
    public String registerNewPatient() {
        return "PatientRegister";
    }

    /**
     * 病人注册
     * @param username
     * @param password
     * @param trueName
     * @param email
     * @param mobile
     * @param age
     * @param gender
     * @param disease
     * @param allHis
     * @param department
     * @param describe
     * @return
     * @throws InterruptedException
     */
    @Transactional
    @RequestMapping(value = "insert",method = POST)
    public String registerNewPatient(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     @RequestParam("trueName") String trueName,
                                     @RequestParam("email") String email,
                                     @RequestParam("mobile") String mobile,
                                     @RequestParam("age") String age,
                                     @RequestParam("gender") String gender,
                                     @RequestParam("disease") String disease,
                                     @RequestParam("allergy") String allHis,
                                     @RequestParam("department") String department,
                                     @RequestParam("describe") String describe) throws InterruptedException {
        Date date = new Date();
        /** User **/
        User user = new User();
        user.setUsername(username.trim());
        user.setAvator("/static/img/user.png");//default
        user.setPassword(password.trim());
        user.setTrueName(trueName.trim());
        user.setEmail(email.trim());
        user.setMobile(mobile.trim());
        user.setAge(Integer.valueOf(age.trim()));
        user.setGender(Boolean.valueOf(gender));
        user.setCreateBy(1);
        user.setCreateTime(date);
        user.setIfEmloyee(false);
        userService.save(user);
        int id = user.getId();
        Thread.sleep(500);
        /** patient **/
        PatientInfo patientInfo = new PatientInfo();
        patientInfo.setUserId(user.getId());
        patientInfo.setAlleHis(allHis);
        patientInfo.setCreateBy(1);
        patientInfo.setCreateTime(date);
        patientInfo.setInpatient(false);
        patientInfo.setInHospitalId(0);
        patientService.save(patientInfo);

        /**PatientRole **/
        UserRole role = new UserRole();
        role.setRoleId(5);
        role.setUserId(user.getId());
        userRoleService.save(role);


        /** medical init **/
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setPatientId(user.getId());
        medicalRecord.setCreateBy(1);
        medicalRecord.setCreateTime(date);
        medicalRecord.setDiseaseDetail(describe);
        medicalRecordService.save(medicalRecord);
        /**message **/
        List<EmployeeInfo> doctors = employeeService.getEmployeeInfoByDepartment(Integer.valueOf(department));
        List<User> docs = new ArrayList<>();
        for(EmployeeInfo doctor : doctors) {
            User doc = userService.get(doctor.getUserId());
            docs.add(doc);
        }
        for(User doc : docs) {
            Message message = new Message();
            message.setToId(doc.getId());
            message.setFromId(user.getId());
            message.setMessage(describe);
            message.setCreateTime(date);
            messageService.save(message);
        }
        /** patient log **/
        PatientLog log = new PatientLog();
        log.setPatientId(id);
        log.setWhen(date);
        log.setType("joining");
        log.setWhat("joining the hospital at "+date);
        patientLogService.save(log);
        return "login";
    }


    /**
     * 病人出院
     * @param userId
     */
    @Transactional
    @RequestMapping(value = "discharge",method = POST)
    public void discharge(@RequestParam("userId") String userId) {
        Date date = new Date();
        int id = Integer.valueOf(userId);
        PatientInfo patientInfo = patientService.getPatientInfo(id);
        /** ward **/
        InHospitalInfo inHospitalInfo = inHospitalInfoService.get(patientInfo.getInHospitalId());
        Ward ward = wardService.get(inHospitalInfo.getWardNum());
        int oldNum = ward.getNum();
        ward.setNum(oldNum - 1);
        ward.setUpdateBy(1);
        ward.setUpdateTime(date);
        wardService.update(ward);
        /** InHospital **/
        inHospitalInfoService.delete(inHospitalInfo);
        /** patient **/
        patientInfo.setInHospitalId(0);
        patientInfo.setInpatient(false);
        User session = (User) WebUtil.getCurrentUser();
        patientInfo.setUpdateBy(session.getId());
        patientInfo.setUpdateTime(date);
        patientService.update(patientInfo);

        /** message **/
        Message message = new Message();
        message.setMessage("Congratulations on your discharge from hospital :)");
        message.setFromId(session.getId());
        message.setCreateTime(date);
        message.setToId(id);
        messageService.save(message);

        /** patient log **/
        PatientLog log = new PatientLog();
        log.setPatientId(id);
        log.setWhen(date);
        log.setType("discharge");
        log.setWhat("discharged by Doctor."+session.getTrueName()+" at "+date+", Stayed in the "+ward.getLocation());
        patientLogService.save(log);
    }


    /**
     * 入院
     * @param userId
     * @param wardId
     */
    @Transactional
    @RequestMapping(value = "admission",method = POST)
    public void admission(@RequestParam("userId") String userId,
                          @RequestParam("wardId") String wardId) throws InterruptedException {
        Date date = new Date();
        User session = (User) WebUtil.getCurrentUser();
        int employeeId = session.getId();
        int patientId = Integer.valueOf(userId);
        PatientInfo patientInfo = patientService.getPatientInfo(patientId);
        patientInfo.setUpdateTime(date);
        patientInfo.setUpdateBy(employeeId);
        patientInfo.setInpatient(true);

        /** ward **/
        Ward ward = wardService.getWardByLocation(wardId);
        int oldNum = ward.getNum();
        ward.setNum(oldNum+1);
        ward.setUpdateTime(date);
        ward.setUpdateBy(1);
        wardService.update(ward);

        /** inhospitalInfo **/
        InHospitalInfo inHospitalInfo = new InHospitalInfo();
        inHospitalInfo.setStartTime(date);
        inHospitalInfo.setWardNum(ward.getId());
        inHospitalInfo.setFee(new BigDecimal(500));
        inHospitalInfo.setUserId(patientId);
        inHospitalInfoService.save(inHospitalInfo);
        Thread.sleep(300);
        patientInfo.setInHospitalId(inHospitalInfo.getId());
        patientService.update(patientInfo);

        /** patient log **/
        PatientLog patientLog = new PatientLog();
        patientLog.setPatientId(patientId);
        patientLog.setType("Hospitalized");
        patientLog.setWhen(date);
        patientLog.setWhat("hospitalized by "+session.getTrueName()+" at "+date+",ward locates at "+ward.getLocation());
        patientLogService.save(patientLog);
        /**Message **/
        Message message = new Message();
        message.setToId(patientId);
        message.setFromId(employeeId);
        message.setCreateTime(date);
        message.setMessage("Hospitalized Success,you ward location is "+ward.getLocation());
        messageService.save(message);
    }
}
