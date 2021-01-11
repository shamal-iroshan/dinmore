/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receiverImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import model.OrderModel;
import receiver.OrderReceiver;
import views.Chef;

/**
 *
 * @author Shamal
 */
public class OrderReceiverImpl extends UnicastRemoteObject implements OrderReceiver<OrderModel>{

    Chef chef;
    
    public OrderReceiverImpl(Chef chef) throws RemoteException{
        this.chef = chef;
    }
    
    @Override
    public void update(OrderModel order) throws RemoteException {
        chef.update(order);
    }
    
}
