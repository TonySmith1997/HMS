package com.hms.type;

import java.math.BigDecimal;

public enum CheckType {
    CT("CT",new BigDecimal(500)),
    Xray("X-ray",new BigDecimal(230)),
    URAN("URAN",new BigDecimal(344)),
    BloodTest("Blood test",new BigDecimal(222));

    CheckType(String name, BigDecimal fee) {
        this.name = name;
        this.fee = fee;
    }

    private String name;
    private BigDecimal fee;

    public static BigDecimal getValue(String name){
        for(CheckType e : CheckType.values()) {
            if(e.getName().trim() == name.trim()) {
                return e.fee;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
