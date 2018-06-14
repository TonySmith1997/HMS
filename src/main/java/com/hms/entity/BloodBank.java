package com.hms.entity;

import com.hms.core.base.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
@Proxy(lazy = false)
@Entity
public class BloodBank extends BaseEntity{
    @Id
    @GeneratedValue
    private int id;
    private String bloodType;//血型
    private BigDecimal qty;//储量,ml or cc

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
}
