package com.hms.entity;

import com.hms.core.base.BaseEntity;
import com.hms.entity.logs.PatientLog;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Proxy(lazy = false)
@Entity
public class PatientInfo extends BaseEntity{
    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private boolean inpatient;//是否住院？：1住院，2门诊
    private int inHospitalId;//住院信息id，默认为null
    private String alleHis;//过敏历史
    @Transient
    private User user;
    @Transient
    private List<PatientLog> patientLogs;
    @Transient
    private InHospitalInfo inHospitalInfo;
    @Transient
    private Ward ward;

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public InHospitalInfo getInHospitalInfo() {
        return inHospitalInfo;
    }

    public void setInHospitalInfo(InHospitalInfo inHospitalInfo) {
        this.inHospitalInfo = inHospitalInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PatientLog> getPatientLogs() {
        return patientLogs;
    }

    public void setPatientLogs(List<PatientLog> patientLogs) {
        this.patientLogs = patientLogs;
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

    public boolean isInpatient() {
        return inpatient;
    }

    public void setInpatient(boolean inpatient) {
        this.inpatient = inpatient;
    }

    public int getInHospitalId() {
        return inHospitalId;
    }

    public void setInHospitalId(int inHospitalId) {
        this.inHospitalId = inHospitalId;
    }
}
