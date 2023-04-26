package com.delivery.apidelivery.entity;

import java.time.LocalTime;
import java.util.List;

public class Order {

    private String id;
    private String customerName;
    private String customerEmail;
    private String status;
    private LocalTime creationTime;
    private LocalTime estimatedDeliveryTime;
    private List<Food> items;

    public Order(String id, String customerName, String customerEmail,List<Food> items) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.status = "En proceso";
        this.creationTime = LocalTime.now();
        this.estimatedDeliveryTime = null;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(LocalTime estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }


    public double priceTotal(){
       double montoTotal = 0;
        for (Food oF: items) {
            montoTotal = montoTotal + oF.getPrice();
        }
        return montoTotal;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", status='" + status + '\'' +
                ", creationTime=" + creationTime +
                ", estimatedDeliveryTime=" + estimatedDeliveryTime +
                ", items=" + items +
                '}';
    }
}
