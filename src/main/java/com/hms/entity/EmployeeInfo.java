package com.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hms.core.base.BaseEntity;
import com.hms.entity.logs.EmployeeLog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * including doctor and data input operator
 */
@Entity
public class EmployeeInfo extends BaseEntity {
    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private int departId;//科室Id
    private int status;//1.在班，0下班 3.离职
    private boolean ifHead;
    /**
     * Chief,Associate Chief,Attending,Intern
     */
    private String type;
    private String description;
    @Transient
    private User user;
    @Transient
    @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
    @JsonSerialize
    private List<EmployeeLog> employeeLogs;

    public List<EmployeeLog> getEmployeeLogs() {
        return employeeLogs;
    }

    public void setEmployeeLogs(List<EmployeeLog> employeeLogs) {
        this.employeeLogs = employeeLogs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIfHead() {
        return ifHead;
    }

    public void setIfHead(boolean ifHead) {
        this.ifHead = ifHead;
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

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
