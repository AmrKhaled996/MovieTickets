/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.movie.GUI;


import com.mycompany.movie.Database;
import com.mycompany.movie.Movies.Movie;
import com.mycompany.movie.Movies.MovieLibrary;
import com.mycompany.movie.Movies.ScreenTime;
import com.mycompany.movie.Movies.enGenre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class BookMovie1 extends javax.swing.JPanel {

    /**
     * Creates new form BookMovie
     */
    public BookMovie1(program prog) {
        initComponents1(prog);
        setName("BookMovie");
        setSize(700,450);
        
         bookMovieBackBtn.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               MainMenu11 main = new MainMenu11();
               main.show();
//               dispose();
           }});
        
//        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
          
private void initComponents1(program prog) {
    // Set default size of the frame
    setSize(599, 414);

    // Create a panel to hold the labels
    javax.swing.JPanel panel = new javax.swing.JPanel();
    
    javax.swing.JPanel bookmovieMainPanel = new javax.swing.JPanel();
    bookmovieMainPanel.setSize(700,450);
    bookmovieMainPanel.setLayout(new BoxLayout(bookmovieMainPanel , BoxLayout.Y_AXIS));
    
    panel.setLayout(new java.awt.GridLayout(0, 5, 10, 10)); // Auto-rows, 5 columns, 10px gap
    
    bookMovieBackBtn.setBackground(new Color(51, 153, 255));
    bookMovieBackBtn.setForeground(new Color(255, 255, 255));
    
    panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.setSize(599,414);
    
    bookmovieMainPanel.add(bookMovieBackBtn);
    bookmovieMainPanel.add(panel);
    
    
    
    
       
        MovieLibrary lib = new MovieLibrary(Database.listMoviesWithScreenTimes());
        
        
        
        
        
        
        
        
//        for (int i=0 ;i<100;i++){
//            JPanel tempJPanel=new JPanel();
//            tempJPanel.setLayout(new BoxLayout(tempJPanel , BoxLayout.Y_AXIS));
//            tempJPanel.setSize(new Dimension(110, 110));
//        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
//        jLabel1.setText("  ");
//        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Center text
//        jLabel1.setPreferredSize(new Dimension(100,100));
//        jLabel1.setSize(new Dimension(100,100));
//        
//        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK)); // Optional, for visibility
//        
//        tempJPanel.add(jLabel1);
//        
//        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
//        jLabel2.setText("movie "+i);
//        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Center text
//        jLabel2.setPreferredSize(new Dimension(100, 5));
//        jLabel2.setForeground(Color.blue);
//        
//        
//        
//        panel.add(tempJPanel);
//        tempJPanel.addMouseListener(new MouseAdapter() {
//                        public void mouseClicked(MouseEvent e) {
//                            System.out.println( jLabel2.getText());    
//                        
//                        
//                        
//                        
//                        
//                        
//                        }
//                    });
//        tempJPanel.add(jLabel2);
//
//       
//    }
//        
    // Dynamically add labels to the panel
    
    for (Movie movy : MovieLibrary.getMovies()){
        
         JPanel tempJPanel=new JPanel();
            tempJPanel.setLayout(new BoxLayout(tempJPanel , BoxLayout.Y_AXIS));
            tempJPanel.setSize(new Dimension(110, 110));
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jLabel1.setText(movy.getPoster());
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Center text
//        jLabel1.setPreferredSize(new Dimension(100,100));
        jLabel1.setSize(new Dimension(100,100));
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK)); // Optional, for visibility

         tempJPanel.add(jLabel1);
        
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        jLabel2.setText(movy.getTitle());
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Center text
        jLabel2.setPreferredSize(new Dimension(100, 5));
        jLabel2.setForeground(Color.blue);
        
        
        
         panel.add(tempJPanel);
        tempJPanel.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                         
                            prog.switchToPanel("BookSeats");
                        }
                    });
        
         tempJPanel.add(jLabel2);
        
        panel.add(tempJPanel);
       
    }
    

    // Create a scroll pane and add the panel to it
    javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(bookmovieMainPanel);

    scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    
    scrollPane.setPreferredSize(new Dimension(700, 450));
 
    

    add(scrollPane);
   
    // Pack the frame (optional for fixed size, already set above)
    // pack(); 
}


    /**
     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(BookMovie1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BookMovie1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BookMovie1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BookMovie1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new BookMovie1(program).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
   
    private JButton bookMovieBackBtn=new JButton("Back");
    public static int MovieId;
}
