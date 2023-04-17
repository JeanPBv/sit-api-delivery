package entity;

import org.springframework.cglib.core.Local;

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

    public Order(String id, String customerName, String customerEmail, String status, LocalTime creationTime, LocalTime estimatedDeliveryTime, List<Food> items) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.status = status;
        this.creationTime = creationTime;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
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

}
