package com.hms.web;

import com.hms.core.util.AvatorCopy;
import com.hms.core.util.WebUtil;
import com.hms.entity.*;
import com.hms.service.*;
import com.hms.type.CheckType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/check")
@Controller
public class CheckController {
    @Autowired
    private UserService userService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private MedicalRecordService medicalRecordService;

    @RequestMapping("")
    public String getRecordPage() {
        return "checkList";
    }



    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getRecordList(ModelMap map) {
       List<PhysicalExamination> checks = checkService.getAll();
       List<PhysicalExamination> checks2 = new ArrayList<>();
       for(PhysicalExamination check : checks) {
           User patient = userService.get(check.getPatientId());
           User staff = userService.get(check.getCheckBy());
           check.setPatient(patient);
           check.setStaff(staff);
           checks2.add(check);
       }
       map.addAttribute("checks",checks2);
       return "checkList";
    }

    @Transactional
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void updateRecord(@RequestParam("checkName") String checkName,
                        @RequestParam("patientId") String patientId,
                        @RequestParam("checkResult") String checkResult,
                        @RequestParam("imgData") String dataURL) throws IOException, InterruptedException {

        Date date = new Date();
        String path = "/Users/tony/Documents/HMS/src/main/webapp/static/img/check/";
        int id = Integer.valueOf(patientId);
        User user =  userService.get(id);
        String imgName = "("+patientId +")_"+date+".png";
        AvatorCopy.decodeBase64DataURLToImage(dataURL,path,imgName);
        PhysicalExamination check = new PhysicalExamination();
        check.setCheckName(checkName.trim());
        check.setCheckResult(checkResult);
        check.setPicture("/static/img/check/"+imgName);
        User session = (User) WebUtil.getCurrentUser();
        check.setCreateBy(session.getId());
        check.setCreateTime(date);
        check.setCheckBy(session.getId());
        check.setPatientId(id);
        check.setFee(CheckType.getValue(checkName.trim()));
        MedicalRecord medicalRecord = medicalRecordService.getRecordByUserId(id);
        check.setMedicalRecordId(medicalRecord.getId());
        checkService.save(check);

        Thread.sleep(500);
        Message message = new Message();
        message.setCreateTime(date);
        message.setMessage(checkName+","+checkResult);
        message.setToId(id);
        message.setFromId(session.getId());
        message.setPhoto(check.getPicture());
        messageService.save(message);
    }
}
