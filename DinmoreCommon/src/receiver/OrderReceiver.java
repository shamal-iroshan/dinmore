/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receiver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Shamal
 */
public interface OrderReceiver<T> extends Remote {
    public void update(T order) throws RemoteException;
}
