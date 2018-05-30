package com.hms.entity;

import com.hms.core.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class DrugStock extends BaseEntity{
    @Id
    @GeneratedValue
    private int id;
    private int drugId;
    private int qty;//库存容量

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
