package com.btx.domain;

import java.io.Serializable;

public class Order implements Serializable{

    private String orderId;
    private Integer number;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
