package com.hms.entity;

import com.hms.core.base.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Proxy(lazy = false)
@Entity
public class User extends BaseEntity{
    @Id
    @GeneratedValue
    private int id;
    private String username;//for login,must be 数字加字母不能有@
    private String trueName;//真实姓名
    private String password;
    private String email;
    private String mobile;
    private String avator;
    private int age;
    private boolean gender;//male 1，female 0
    private boolean ifEmloyee;
    @Transient
    private Set<String> role;

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isIfEmloyee() {
        return ifEmloyee;
    }

    public void setIfEmloyee(boolean ifEmloyee) {
        this.ifEmloyee = ifEmloyee;
    }
}
