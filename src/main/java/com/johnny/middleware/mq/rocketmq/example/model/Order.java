package com.johnny.middleware.mq.rocketmq.example.model;

public class Order {
    private long orderId;
    private String orderType;

    public Order(long orderId, String orderType) {
        this.orderId = orderId;
        this.orderType = orderType;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
