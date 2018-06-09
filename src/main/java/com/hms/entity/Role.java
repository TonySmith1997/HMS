package com.hms.entity;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 角色
 */
@Proxy(lazy = false)
@Entity
public class Role implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String rolename;
    private String Descrption;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescrption() {
        return Descrption;
    }

    public void setDescrption(String descrption) {
        Descrption = descrption;
    }
}
