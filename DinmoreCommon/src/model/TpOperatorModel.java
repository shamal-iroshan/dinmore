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
public class TpOperatorModel implements SuperModel{
    private String id;
    private String cusContact;
    private String cusName;
    private String qty;

    public TpOperatorModel() {
    }

    public TpOperatorModel(String id, String cusContact, String cusName, String qty) {
        this.id = id;
        this.cusContact = cusContact;
        this.cusName = cusName;
        this.qty = qty;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCusContact() {
        return cusContact;
    }

    public void setCusContact(String cusContact) {
        this.cusContact = cusContact;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
    
    
}
