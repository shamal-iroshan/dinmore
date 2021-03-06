/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controllerImpl.OrderControllerImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shamal
 */
public class Server {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(5050);
            System.out.println("Starting server....");
            registry.rebind("DinMoreServer", new OrderControllerImpl());

        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
