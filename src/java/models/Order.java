/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author lephu
 */
public class Order {
    private int orderId;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private Shipper shipper;
    private String shipName;
    private String shipAddress;

    public Order(int orderId, LocalDate orderDate, LocalDate requiredDate, Shipper shipper, String shipName, String shipAddress) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shipper = shipper;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
    }
    
    public Order(LocalDate requiredDate, Shipper shipper, String shipName, String shipAddress) {
        
        this.requiredDate = requiredDate;
        this.shipper = shipper;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }
    
}
