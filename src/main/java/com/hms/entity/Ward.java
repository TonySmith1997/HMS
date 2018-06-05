package com.hms.entity;

import com.hms.core.base.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 病房管理
 */
@Proxy(lazy = false)
@Entity
public class Ward extends BaseEntity{
    @Id
    @GeneratedValue
    private int id;
    private String location;
    private int num;//病房现存人数
    private int totalNum;//病房可供总人数
    @Transient
    private List<InHospitalInfo> patientInfos;

    public List<InHospitalInfo> getPatientInfos() {
        return patientInfos;
    }

    public void setPatientInfos(List<InHospitalInfo> patientInfos) {
        this.patientInfos = patientInfos;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
