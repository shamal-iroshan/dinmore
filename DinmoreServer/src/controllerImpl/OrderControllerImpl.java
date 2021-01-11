/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerImpl;

import controller.OrderController;
import dbConnection.DBConnection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChefDetailModel;
import model.ChefSummeryModel;
import model.OrderModel;
import model.TpOperatorModel;
import receiver.OrderReceiver;

/**
 *
 * @author Shamal
 */
public class OrderControllerImpl extends UnicastRemoteObject implements OrderController<OrderModel> {

    ArrayList<OrderReceiver> receivers = new ArrayList();
    ArrayList<OrderModel> orders = new ArrayList();
    ArrayList<OrderModel> takenOrders = new ArrayList();
    

    public OrderControllerImpl() throws RemoteException {
    }

    @Override
    public void addOrders(OrderModel order) throws RemoteException {
        orders.add(order);
        notifyReceivers();
    }

    @Override
    public void notifyReceivers() throws RemoteException {
        if (orders.size() > 0) {
            for (OrderReceiver receiver : receivers) {
                receiver.update(orders.get(0));
            }
        }else{
            OrderModel orderModel = new OrderModel();
            orderModel.setQty("0");           
            for (OrderReceiver receiver : receivers) {
                receiver.update(orderModel);
            }
            
        }
    }

    @Override
    public OrderModel takeOrder() throws RemoteException {
        if (orders.size() > 0) {
            OrderModel temp = orders.get(0);
            orders.remove(0);
            takenOrders.add(temp);
            return temp;
        }
        return null;
    }

    @Override
    public void saveOrder(OrderModel order) throws RemoteException {
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement("INSERT INTO orders VALUES(?,?,?,?,?,?,?,?)");
            stm.setString(1, order.getOrderID());
            stm.setString(2, order.getCustomerName());
            stm.setString(3, order.getTpNumber());
            stm.setString(4, order.getQty());
            stm.setString(5, order.getProcessingTime());
            stm.setString(6, order.getDate());
            stm.setString(7, order.getTpOperatorID());
            stm.setString(8, order.getChefID());
            stm.executeUpdate();
            takenOrders.remove(0);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addReceiver(OrderReceiver receiver) throws RemoteException {
        receivers.add(receiver);
    }

    @Override
    public void removeReceiver(OrderReceiver receiver) throws RemoteException {
        receivers.remove(receiver);
    }

    @Override
    public String getOrderID() throws RemoteException {

        try {

            Connection connection = DBConnection.getInstance().getConnection();
            ResultSet rst = connection.prepareStatement("SELECT idorders FROM orders ORDER BY idorders DESC LIMIT 1").executeQuery();
            if (rst.next()) {
                int id = Integer.valueOf(rst.getString(1));
                id++;
                id += orders.size();
                id += takenOrders.size();
                return String.valueOf(id);
            }
            return "1";

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<String> getDates() throws RemoteException {
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            ResultSet rst = connection.prepareStatement("SELECT DISTINCT date FROM orders ORDER BY date DESC").executeQuery();
            ArrayList<String> list = new ArrayList();
            while (rst.next()) {
                list.add(rst.getString(1));
            }
            return list;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ChefSummeryModel getChefSummery(String id, String date) throws RemoteException {
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT chef.name,COUNT(orders.idorders),SUM(orders.qty),SUM(orders.processingTime)"
                    + " FROM chef INNER JOIN orders ON chef.ID = orders.chefID"
                    + " WHERE orders.chefID=? AND orders.date=?");
            stm.setString(1, id);
            stm.setString(2, date);
            ResultSet rst = stm.executeQuery();
            if (rst.next()) {
                return new ChefSummeryModel(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4)
                );
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<TpOperatorModel> getTPDetails(String id, String date) throws RemoteException {
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT tpOperatorID,customerNumber,customerName,qty FROM orders "
                    + "WHERE tpOperatorID=? AND date=?");
            stm.setString(1, id);
            stm.setString(2, date);
            ResultSet rst = stm.executeQuery();
            ArrayList<TpOperatorModel> list = new ArrayList();

            while (rst.next()) {
                list.add(new TpOperatorModel(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4)
                ));
            }
            return list;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<ChefDetailModel> getChefDetails(String id, String date) throws RemoteException {

        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT chefID,customerName,processingTime,qty FROM orders "
                    + "WHERE chefID=? AND date=?");
            stm.setString(1, id);
            stm.setString(2, date);
            ResultSet rst = stm.executeQuery();
            ArrayList<ChefDetailModel> list = new ArrayList();

            while (rst.next()) {
                list.add(new ChefDetailModel(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4)
                ));
            }
            return list;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
