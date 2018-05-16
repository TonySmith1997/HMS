package com.hms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class TotalFee implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private List checkIds;
    private List drugIds;//DrugFee's id
    private int patientId;
    private BigDecimal totalFee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getCheckIds() {
        return checkIds;
    }

    public void setCheckIds(List checkIds) {
        this.checkIds = checkIds;
    }

    public List getDrugIds() {
        return drugIds;
    }

    public void setDrugIds(List drugIds) {
        this.drugIds = drugIds;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }
}
