package com.hms.entity;

import com.hms.core.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


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
    private int status;//1.在班，2.下班 3.离职
    private Date startTime;//入职时间
    private Date endTime;//离职时间，默认为null

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
