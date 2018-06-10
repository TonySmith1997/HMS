package com.hms.web;

import com.hms.core.util.WebUtil;
import com.hms.entity.*;
import com.hms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/record")
@Controller
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;
    @Autowired
    private DrugService drugService;
    @Autowired
    private DrugFeeService drugFeeService;
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private InHospitalInfoService inHospitalInfoService;
    @Autowired
    private WardService  wardService;
    @Autowired
    private CheckService checkService;

    @RequestMapping("")
    public String getRecordPage() {
        return "medicalRecord";
    }


    /**
     *
     * @param id
     * @param map
     * @return
     */
    @Transactional
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public String getMedicalRecordById(@PathVariable String id, ModelMap map) {
        /**patient part **/
        Integer patientId = Integer.valueOf(id);
        User user = userService.get(patientId);
        PatientInfo patient = patientService.getPatientInfo(patientId);
        if(patient.isInpatient()) {
            InHospitalInfo inHospitalInfo= inHospitalInfoService.get(patient.getInHospitalId());
            Ward ward = wardService.get(inHospitalInfo.getWardNum());
            patient.setWard(ward);
        }
        patient.setUser(user);

        MedicalRecord medicalRecord = medicalRecordService.getRecordByUserId(patientId);



        /**Doctor part **/
        String doctorIds = medicalRecord.getDoctorId();
        List<User> employeeInfos = new ArrayList<>();
        String[] dd = doctorIds.split(";");
        for(int i =0 ;i<dd.length;i++) {
            User doctor = userService.get(Integer.valueOf(dd[i]));
            employeeInfos.add(doctor);
        }
        medicalRecord.setPatientInfo(patient);
        medicalRecord.setDoctor(employeeInfos);

        /** session **/
        User session = (User) WebUtil.getCurrentUser();
        for(User employeeInfo : employeeInfos) {
            if(session.getId()==employeeInfo.getId()) {
                map.addAttribute("permission",true);
                break;
            }
            else{
                map.addAttribute("permission",false);
            }
        }
        System.out.println(session + " " + map.get("permission"));

        /**drug part **/
        List<DrugFee> drugFees = drugFeeService.getDrugFeeByPatient(patientId);
        int drugId;
        for(DrugFee drugFee : drugFees) {
            drugId  = drugFee.getDrugId();
            Drug drug = drugService.get(drugId);
            drugFee.setDrug(drug);
        }
        medicalRecord.setDrugs(drugFees);

        /**check part **/
        List<PhysicalExamination> checks = checkService.getCheckByPatient(patientId);
        int staffId;
        for(PhysicalExamination check : checks) {
            staffId = check.getCheckBy();
            EmployeeInfo staffInfo = employeeService.getEmployeeInfo(staffId);
            User staff = userService.get(staffId);
            staffInfo.setUser(staff);
            check.setEmployeeInfo(staffInfo);
        }


        medicalRecord.setPhysicalExaminations(checks);
        map.addAttribute("record",medicalRecord);
        return "medicalRecord";
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getRecordList(ModelMap map) {
        List<MedicalRecord> records = medicalRecordService.getAllRecord();
        List<MedicalRecord> records1 = new ArrayList<>();
        for(MedicalRecord record : records) {
            int userId = record.getPatientId();
            User user = userService.get(userId);
            PatientInfo patientInfo = patientService.getPatientInfo(userId);
            patientInfo.setUser(user);
            record.setPatientInfo(patientInfo);
            records1.add(record);
        }
        map.addAttribute("records",records1);
        return "medicalrecordList";
    }

    @Transactional
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void updateRecord(@RequestParam("diseaseDetail") String diseaseDetail,
                        @RequestParam("diseaseName") String diseaseName,
                        @RequestParam("recommand") String recommand,
                        @RequestParam("recordId") String recordId) {
        MedicalRecord medicalRecord = medicalRecordService.get(Integer.valueOf(recordId));
        medicalRecord.setDiseaseName(diseaseName);
        medicalRecord.setRecommend(recommand);
        medicalRecord.setDiseaseDetail(diseaseDetail);
        medicalRecordService.update(medicalRecord);
    }
}
