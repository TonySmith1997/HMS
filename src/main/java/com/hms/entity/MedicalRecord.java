package com.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hms.core.base.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

/**
 * 病历
 */
@Proxy(lazy = false)
@Entity
public class MedicalRecord extends BaseEntity{
    @Id
    @GeneratedValue
    private int id;
    private int patientId;//patient
    private String doctorId;//这里的id都是user表的里id id e.g. 1;2;3
    private String diseaseName;//病名
    private String diseaseDetail;
    private String recommend;//（饮食，预防）建议

    @Transient
    private PatientInfo patientInfo;

    @Transient
    @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
    @JsonSerialize
    private List<User> doctor;


    @Transient
    @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
    @JsonSerialize
    private List<DrugFee> drugs;//所开的药

    @Transient
    @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
    @JsonSerialize
    private List<PhysicalExamination> physicalExaminations;//所做的检查

    public List<PhysicalExamination> getPhysicalExaminations() {
        return physicalExaminations;
    }


    public void setPhysicalExaminations(List<PhysicalExamination> physicalExaminations) {
        this.physicalExaminations = physicalExaminations;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }


    public List<DrugFee> getDrugs() {
        return drugs;
    }


    public void setDrugs(List<DrugFee> drugs) {
        this.drugs = drugs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public PatientInfo getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(PatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }

    public String getDiseaseDetail() {
        return diseaseDetail;
    }

    public void setDiseaseDetail(String diseaseDetail) {
        this.diseaseDetail = diseaseDetail;
    }

    public List<User> getDoctor() {
        return doctor;
    }

    public void setDoctor(List<User> doctor) {
        this.doctor = doctor;
    }
}
