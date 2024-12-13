package com.mycompany.movie.GUI;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainMenu1 extends JFrame {

    public MainMenu1() {
        initComponents();
        reportButton.addActionListener(e -> {
            Reports rep = new Reports();
            rep.setVisible(true);
            dispose(); // Remove if you don't want to close the MainMenu frame
        });
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        bookMovieButton = new JButton();
        addMovieButton = new JButton();
        deleteMovieButton = new JButton();
        reportButton = new JButton();
        receiptsButton = new JButton();
        addScreenTimeButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movie System");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Movie System");

        bookMovieButton.setText("Book Movie");
        addMovieButton.setText("Add Movie");
        deleteMovieButton.setText("Delete Movie");
        reportButton.setText("Reports");
        receiptsButton.setText("Receipts");
        addScreenTimeButton.setText("Add ScreenTime");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(154, 154, 154)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(addMovieButton)
                        .addComponent(deleteMovieButton)
                        .addComponent(bookMovieButton))
                    .addGap(87, 87, 87)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(receiptsButton)
                        .addComponent(reportButton)
                        .addComponent(addScreenTimeButton))
                    .addContainerGap(149, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(219, 219, 219))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel1)
                    .addGap(55, 55, 55)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(bookMovieButton)
                        .addComponent(reportButton))
                    .addGap(59, 59, 59)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(receiptsButton)
                        .addComponent(addMovieButton))
                    .addGap(59, 59, 59)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addScreenTimeButton)
                        .addComponent(deleteMovieButton))
                    .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu1().setVisible(true));
    }

    private JButton reportButton;
    private JButton bookMovieButton;
    private JButton addMovieButton;
    private JButton deleteMovieButton;
    private JButton receiptsButton;
    private JButton addScreenTimeButton;
    private JLabel jLabel1;
}
