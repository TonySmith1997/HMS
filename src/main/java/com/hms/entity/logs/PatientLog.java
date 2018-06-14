package com.hms.entity.logs;

import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Proxy(lazy = false)
@Entity
public class PatientLog implements Serializable{
    @Id
    @GeneratedValue
    private int id;


    private int patientId;

    private String what;//doing what

    @Column(name = "happen_time")
    private Date when;
    /**
     * (registered)patient be registered by DIO
     * (healed)patient be healed by patient
     * (hospitalized)patient be hospitalized by nurse 入院治疗
     * (leave)patient be leaved by nurse 出院
     */
    private String type;

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

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
