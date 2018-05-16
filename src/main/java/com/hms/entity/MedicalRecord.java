package com.hms.entity;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

/**
 * 病历
 */
@Entity
public class MedicalRecord implements Serializable{
    private int id;
    private int patientId;
    private int doctorId;//这里的id都是user表的里id
    private String diseaseName;//病名
    private String recommend;//（饮食，预防）建议
    private List<DrugFee> drugs;//所开的药
    private List<Check> checks;//所做的检查

    public List<Check> getChecks() {
        return checks;
    }

    public void setChecks(List<Check> checks) {
        this.checks = checks;
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
