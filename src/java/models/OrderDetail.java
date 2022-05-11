/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author lephu
 */
public class OrderDetail {
    private int orderId;
    private int productId;
    private int quantiy;
    private double unitPrice;

    public OrderDetail(int orderId, int productId, int quantiy, double unitPrice) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantiy = quantiy;
        this.unitPrice = unitPrice;
    }
    public OrderDetail(int productId, int quantiy) {
        this.productId = productId;
        this.quantiy = quantiy;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(int quantiy) {
        this.quantiy = quantiy;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
}
