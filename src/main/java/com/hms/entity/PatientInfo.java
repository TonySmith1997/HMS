package com.hms.entity;

import com.hms.core.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PatientInfo extends BaseEntity{
    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private int IsInpatient;//是否住院？：1住院，2门诊
    private int inHospitalId;//住院信息id，默认为null
    private String medHis;//药物历史
    private String alleHis;//过敏历史
    private int status;//是否出院

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMedHis() {
        return medHis;
    }

    public void setMedHis(String medHis) {
        this.medHis = medHis;
    }

    public String getAlleHis() {
        return alleHis;
    }

    public void setAlleHis(String alleHis) {
        this.alleHis = alleHis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsInpatient() {
        return IsInpatient;
    }

    public void setIsInpatient(int isInpatient) {
        IsInpatient = isInpatient;
    }

    public int getInHospitalId() {
        return inHospitalId;
    }

    public void setInHospitalId(int inHospitalId) {
        this.inHospitalId = inHospitalId;
    }
}
