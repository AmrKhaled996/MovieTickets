/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.movie.GUI;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
*database 
* *reports
* panel 
* receipt
 */
public class program extends javax.swing.JFrame {

    /**
     * Creates new form program
     */
    public program() {
        initComponents1();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *//*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookSeats11 = new com.mycompany.movie.GUI.BookSeats1();
        bookMovie11 = new com.mycompany.movie.GUI.BookMovie1();
        bookSeats12 = new com.mycompany.movie.GUI.BookSeats1();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        bookMovie11.setSize(599, 419);
        getContentPane().add(bookMovie11, "card2");
        getContentPane().add(bookSeats12, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    */
        private void initComponents1() {
        setTitle("Label Click Example with Separate Classes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bookSeats11 = new com.mycompany.movie.GUI.BookSeats1(this);
        bookMovie11 = new com.mycompany.movie.GUI.BookMovie1(this);
        

        // Initialize CardLayout and main panel
         cardLayout = new CardLayout();
         mainPanel = new JPanel(cardLayout);

        // Create the panels
        
        // Add panels to the main panel
        mainPanel.add(bookMovie11, "BookMovie");
        mainPanel.add(bookSeats11, "BookSeats");

        add(mainPanel);
    }

    public void switchToPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public JPanel getPanel(String panelName) {
        for (var comp : mainPanel.getComponents()) {
            if (comp instanceof JPanel && mainPanel.getLayout() instanceof CardLayout) {
                if (panelName.equals(((JPanel) comp).getName())) {
                    return (JPanel) comp;
                }
            }
        }
        return null;
    }
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
            java.util.logging.Logger.getLogger(program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new program().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.movie.GUI.BookMovie1 bookMovie11;
    private com.mycompany.movie.GUI.BookSeats1 bookSeats11;
    private com.mycompany.movie.GUI.BookSeats1 bookSeats12;
    // End of variables declaration//GEN-END:variables
    private CardLayout cardLayout;
    private JPanel mainPanel;

}