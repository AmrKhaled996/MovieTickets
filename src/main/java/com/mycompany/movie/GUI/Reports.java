/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.movie.GUI;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author MU
 */
public class Reports extends JFrame {

    /**
     * Creates new form Reports
     */
    public Reports() {
        initComponents();
        
         redo.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               MainMenu11 main = new MainMenu11();
                main.show();
               dispose();
           }   
           });
         soldseat.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               SoldSeats ss = new SoldSeats();
                ss.show();
               dispose();;
               
           }   
           });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redo = new javax.swing.JButton();
        soldseat = new javax.swing.JButton();
        mostwatch = new javax.swing.JButton();
        crowdtime = new javax.swing.JButton();
        numberseat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Report");

        redo.setBackground(new java.awt.Color(51, 153, 255));
        redo.setForeground(new java.awt.Color(255, 255, 255));
        redo.setText("Back");
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });

        soldseat.setText("Number of Sold Seats");
        soldseat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soldseatActionPerformed(evt);
            }
        });

        mostwatch.setText("Most Watched Movie");

        crowdtime.setText("Get Crowded Time");

        numberseat.setText("Get Number of Seats");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(redo)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(soldseat)
                    .addComponent(mostwatch)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(crowdtime)
                        .addComponent(numberseat)))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(redo)
                .addGap(28, 28, 28)
                .addComponent(soldseat)
                .addGap(28, 28, 28)
                .addComponent(mostwatch)
                .addGap(30, 30, 30)
                .addComponent(crowdtime)
                .addGap(27, 27, 27)
                .addComponent(numberseat)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redoActionPerformed

    private void soldseatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soldseatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soldseatActionPerformed

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
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crowdtime;
    private javax.swing.JButton mostwatch;
    private javax.swing.JButton numberseat;
    private javax.swing.JButton redo;
    private javax.swing.JButton soldseat;
    // End of variables declaration//GEN-END:variables
}
