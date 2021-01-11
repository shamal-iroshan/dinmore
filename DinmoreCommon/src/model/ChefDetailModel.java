/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Shamal
 */
public class ChefDetailModel implements SuperModel{
    private String ID;
    private String cusName;
    private String time;
    private String qty;

    public ChefDetailModel() {
    }

    public ChefDetailModel(String ID, String cusName, String time, String qty) {
        this.ID = ID;
        this.cusName = cusName;
        this.time = time;
        this.qty = qty;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ChefDetailModel{" + "ID=" + ID + ", cusName=" + cusName + ", time=" + time + ", qty=" + qty + '}';
    }
    
    
}
