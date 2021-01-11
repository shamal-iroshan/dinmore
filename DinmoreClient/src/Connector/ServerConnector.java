/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import controller.OrderController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Shamal
 */
public class ServerConnector {
    private static ServerConnector serverConnector;
    private OrderController orderController;
    
    private ServerConnector() throws NotBoundException, MalformedURLException, RemoteException{
        orderController = (OrderController) Naming.lookup("rmi://localhost:5050/DinMoreServer");
    }
    
    public static ServerConnector getInstance() throws NotBoundException, MalformedURLException, RemoteException{
        return serverConnector == null ? serverConnector = new ServerConnector() : serverConnector;
    }
    
    public OrderController getOrderController(){
        return orderController;
    }
}
