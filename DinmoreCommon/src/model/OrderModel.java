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
public class OrderModel implements SuperModel{
    private String orderID;
    private String customerName;
    private String tpNumber;
    private String qty;
    private String processingTime;
    private String date;
    private String tpOperatorID;
    private String chefID;

    public OrderModel(){
    }

    public OrderModel(String orderID, String customerName, String tpNumber, String qty, String date, String tpOperatorID) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.tpNumber = tpNumber;
        this.qty = qty;
        this.date = date;
        this.tpOperatorID = tpOperatorID;
    }

    public OrderModel(String orderID, String customerName, String tpNumber, String qty, String processingTime, String date, String tpOperatorID, String chefID) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.tpNumber = tpNumber;
        this.qty = qty;
        this.processingTime = processingTime;
        this.date = date;
        this.tpOperatorID = tpOperatorID;
        this.chefID = chefID;
    }
    

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTpNumber() {
        return tpNumber;
    }

    public void setTpNumber(String tpNumber) {
        this.tpNumber = tpNumber;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(String processingTime) {
        this.processingTime = processingTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTpOperatorID() {
        return tpOperatorID;
    }

    public void setTpOperatorID(String tpOperatorID) {
        this.tpOperatorID = tpOperatorID;
    }

    public String getChefID() {
        return chefID;
    }

    public void setChefID(String chefID) {
        this.chefID = chefID;
    }

    @Override
    public String toString() {
        return "OrderModel{" + "orderID=" + orderID + ", customerName=" + customerName + ", tpNumber=" + tpNumber + ", qty=" + qty + ", processingTime=" + processingTime + ", date=" + date + ", tpOperatorID=" + tpOperatorID + ", chefID=" + chefID + '}';
    }


}
