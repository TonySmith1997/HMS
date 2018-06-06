package com.hms.entity.vo;

import java.math.BigDecimal;

public class FeeVo {
    private String name;
    private int num;
    private BigDecimal price;
    private String extraMessage;

    public FeeVo(String name, int num, BigDecimal price, String extraMessage) {
        this.name = name;
        this.num = num;
        this.price = price;
        this.extraMessage = extraMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getExtraMessage() {
        return extraMessage;
    }

    public void setExtraMessage(String extraMessage) {
        this.extraMessage = extraMessage;
    }
}
