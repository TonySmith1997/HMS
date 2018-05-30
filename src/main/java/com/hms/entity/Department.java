package com.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hms.core.base.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Proxy(lazy = false)
@Entity
public class Department extends BaseEntity{
    @Id
    @GeneratedValue
    private int id;
    private String departName;
    private int num;//科室人数
    private String headName;

    private int headId;
    private String description;//中文描述
    private String detail;
    @Transient
    @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
    @JsonSerialize
    private List<EmployeeInfo> employees;

    public List<EmployeeInfo> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeInfo> employees) {
        this.employees = employees;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getHeadId() {
        return headId;
    }

    public void setHeadId(int headId) {
        this.headId = headId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }
}
