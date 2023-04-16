/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Database.databaseManager;
import beanClasses.transactionBean;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class diposit extends javax.swing.JFrame {

    /**
     * Creates new form diposit
     */
    public diposit() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        dateOfTransactionTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        amountTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        doneB = new javax.swing.JButton();
        backB = new javax.swing.JButton();
        accountNoTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        transactionTypeTF = new javax.swing.JTextField();
        amountTypeTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(819, 523));
        getContentPane().setLayout(null);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("DATE OF TRANASACTION");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(120, 170, 150, 40);

        dateOfTransactionTF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(dateOfTransactionTF);
        dateOfTransactionTF.setBounds(300, 180, 210, 40);

        jLabel1.setText("DIPOSIT");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 10, 140, 40);
        getContentPane().add(amountTF);
        amountTF.setBounds(300, 120, 210, 40);

        jLabel2.setText("AMOUNT ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 110, 80, 50);

        doneB.setText("DONE");
        doneB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneBMouseClicked(evt);
            }
        });
        getContentPane().add(doneB);
        doneB.setBounds(340, 350, 130, 50);

        backB.setText("BACK");
        backB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBMouseClicked(evt);
            }
        });
        getContentPane().add(backB);
        backB.setBounds(660, 370, 110, 40);
        getContentPane().add(accountNoTF);
        accountNoTF.setBounds(300, 50, 210, 40);

        jLabel3.setText("ACCOUNT NO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(174, 50, 130, 50);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("TRANSACTION TYPE");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(170, 290, 130, 40);

        transactionTypeTF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(transactionTypeTF);
        transactionTypeTF.setBounds(300, 290, 210, 40);

        amountTypeTF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(amountTypeTF);
        amountTypeTF.setBounds(300, 240, 210, 40);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("AMOUNT TYPE");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(190, 240, 100, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneBMouseClicked
       addRecord();
       
       transactionType obj= new transactionType();
       obj.setVisible(true);
       dispose();
        
    }//GEN-LAST:event_doneBMouseClicked

    private void backBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBMouseClicked
          transactionType obj= new transactionType();
       obj.setVisible(true);
       dispose();
    }//GEN-LAST:event_backBMouseClicked

         private void addRecord(){
    transactionBean bean = new      transactionBean();
    int tra = bean.getTransactionId();

    int amountNo= Integer.parseInt(""+accountNoTF.getText());
    String transactionType = (String)transactionTypeTF.getText();
    int  amount = Integer.parseInt(amountTF.getText());    
    String dateOfTransaction = dateOfTransactionTF.getText();
    String amountType = amountTypeTF.getText();
    //String remarks = "ok";
    try{
        int row = databaseManager.addTransactionD(tra,amountNo, amount,  amountType, dateOfTransaction,transactionType);
        if(row>=1)
                JOptionPane.showMessageDialog(this,"DPOSIT DONE ");
                //clear();
            //    getTransaction();
    }catch(Exception e){
        JOptionPane.showMessageDialog(this,"erorr"+e.getMessage());
        e.printStackTrace();}
    
    
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(diposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(diposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(diposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(diposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new diposit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountNoTF;
    private javax.swing.JTextField amountTF;
    private javax.swing.JTextField amountTypeTF;
    private javax.swing.JButton backB;
    private javax.swing.JTextField dateOfTransactionTF;
    private javax.swing.JButton doneB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField transactionTypeTF;
    // End of variables declaration//GEN-END:variables
}
