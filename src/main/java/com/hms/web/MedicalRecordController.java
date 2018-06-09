package com.hms.web;

import com.hms.entity.*;
import com.hms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        int doctorId = medicalRecord.getDoctorId();
        EmployeeInfo doctor = employeeService.getEmployeeInfo(doctorId);
        User doctorInfo = userService.get(doctor.getUserId());
        doctor.setUser(doctorInfo);
        medicalRecord.setPatientInfo(patient);
        medicalRecord.setDoctor(doctor);

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
}
