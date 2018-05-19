package com.hms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

/**
 * 病历
 */
@Entity
public class MedicalRecord implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private int patientId;
    private int doctorId;//这里的id都是user表的里id
    private String diseaseName;//病名
    private String recommend;//（饮食，预防）建议

    @ManyToMany(mappedBy="medicalRecordId")
    private List<DrugFee> drugs;//所开的药

    @ManyToMany(mappedBy="medicalRecordId")
    private List<physicalExamination> physicalExaminations;//所做的检查

    public List<physicalExamination> getPhysicalExaminations() {
        return physicalExaminations;
    }


    public void setPhysicalExaminations(List<physicalExamination> physicalExaminations) {
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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }
}
