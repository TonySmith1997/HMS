package com.hms.entity.logs;

import com.hms.entity.User;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * EmployeeLog
 */
@Proxy(lazy =false)
@Entity
public class EmployeeLog implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private int who;//user_id
    private String what;//doing what
    private String type;
    /**
     * joining the hospital
     * promoting(if head become 1)
     * demote（when update then if head become 0)
     * transfer(update the departId)
     * firing
     * healing
     * modify
     */
    @Column(name = "happenTime")
    private Date when;

    @Transient
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
