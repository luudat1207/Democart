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
public class Shipper {
    private int shipId;
    private String companyName;

    public Shipper(int shipId, String companyName) {
        this.shipId = shipId;
        this.companyName = companyName;
    }
    
    public Shipper(int shipId) {
        this.shipId = shipId;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
}
