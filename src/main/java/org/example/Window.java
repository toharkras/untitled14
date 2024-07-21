package org.example;

import javax.swing.*;

public class Window extends JFrame {
    public Window(){
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); // Avoid using null layout, prefer layout managers
        this.setResizable(false);
        this.add(new Panel1(0,0,1000,800)); // Add the panel to the frame
        this.setVisible(true);
    }
}
