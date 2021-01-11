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
public class ChefSummeryModel implements SuperModel {
    private String name;
    private String orders;
    private String qty;
    private String time;

    public ChefSummeryModel() {
    }

    public ChefSummeryModel(String name, String orders, String qty, String time) {
        this.name = name;
        this.orders = orders;
        this.qty = qty;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ChefDetailModel{" + "name=" + name + ", orders=" + orders + ", qty=" + qty + ", time=" + time + '}';
    }
    
    
}
