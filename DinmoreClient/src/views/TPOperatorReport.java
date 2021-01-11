/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Connector.ServerConnector;
import controller.OrderController;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TpOperatorModel;

/**
 *
 * @author Shamal
 */
public class TPOperatorReport extends javax.swing.JInternalFrame {

    OrderController controller;

    /**
     * Creates new form ChefSummery
     */
    public TPOperatorReport() {
        initComponents();
        try {
            controller = ServerConnector.getInstance().getOrderController();
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(TPOperatorReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadDates();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbDate = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtData = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cmbID = new javax.swing.JComboBox<>();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(cmbDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 220, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Date :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        txtData.setColumns(20);
        txtData.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtData.setRows(5);
        jScrollPane1.setViewportView(txtData);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 700, 410));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Operator :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        cmbID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cmbID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbID, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 220, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDItemStateChanged
        txtData.setText("");
        txtData.setText(getDateTime() + "\n ");

        String id = "Telephone operator ID :\t ";
        String contact = "Customer contact :\t";
        String name = "Customer name :\t ";
        String qty = "Order quantity :\t ";

        try {
            ArrayList<TpOperatorModel> tpDetails = controller.getTPDetails(cmbID.getSelectedItem().toString(), cmbDate.getSelectedItem().toString());

            for (TpOperatorModel tpDetail : tpDetails) {
                txtData.append(id + tpDetail.getId() + "\n ");
                txtData.append(contact + tpDetail.getCusContact() + "\n ");
                txtData.append(name + tpDetail.getCusName() + "\n ");
                txtData.append(qty + tpDetail.getQty() + "\n ");
                txtData.append("\n--------------------------------------------------------------\n\n ");
            }

            txtData.append("\n This is a system generated report.");
            
        } catch (RemoteException ex) {
            Logger.getLogger(TPOperatorReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbIDItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbDate;
    private javax.swing.JComboBox<String> cmbID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtData;
    // End of variables declaration//GEN-END:variables

    private void loadDates() {
        try {

            ArrayList<String> dates = controller.getDates();
            for (String date : dates) {
                cmbDate.addItem(date);
            }

        } catch (RemoteException ex) {
            Logger.getLogger(ChefSummery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getDateTime() {
        Date D1 = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-dd");
        String datetime = format1.format(D1);
        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
        datetime = datetime + " " + format2.format(D1);
        return datetime;
    }
}
