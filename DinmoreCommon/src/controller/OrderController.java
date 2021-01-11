/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ChefDetailModel;
import model.ChefSummeryModel;
import model.TpOperatorModel;
import receiver.OrderReceiver;

/**
 *
 * @author Shamal
 */
public interface OrderController<T> extends Remote{
    
    public String getOrderID() throws RemoteException;
    
    public void addOrders(T order)throws RemoteException;
    
    public void notifyReceivers()throws RemoteException;
    
    public T takeOrder()throws RemoteException;
    
    public void saveOrder(T order) throws RemoteException;
    
    public void addReceiver(OrderReceiver receiver) throws RemoteException;
    
    public void removeReceiver(OrderReceiver receiver) throws RemoteException;
    
    public ArrayList<String> getDates() throws RemoteException;
    
    public ChefSummeryModel getChefSummery(String id, String date) throws RemoteException;
    
    public ArrayList<TpOperatorModel> getTPDetails(String id, String date) throws RemoteException;
    
    public ArrayList<ChefDetailModel> getChefDetails(String id, String date) throws RemoteException;
    
}
