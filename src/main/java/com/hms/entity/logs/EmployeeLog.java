package com.hms.entity.logs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class EmployeeLog implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private int who;//user_id
    private String what;//doing what
    private Date when;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWho() {
        return who;
    }

    public void setWho(int who) {
        this.who = who;
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
}
