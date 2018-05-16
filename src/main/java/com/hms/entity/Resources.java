package com.hms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Resources implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String resName;
    private String resOp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResOp() {
        return resOp;
    }

    public void setResOp(String resOp) {
        this.resOp = resOp;
    }
}
