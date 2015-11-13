/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Christian
 */
public class SuspendingFlight extends JFrame{

    JPanel base = new JPanel(null);
    JButton baccept = new JButton("Accept");
    JButton bcancel = new JButton("Cancel");
    JTextField tnewtime = new JTextField(10);
    
    public SuspendingFlight(){
        super("Suspend Flight");
        
        JLabel flighttime = new JLabel("Currrent Flight Time");
        flighttime.setBounds(8, 8, 150, 20);
        JLabel newtime = new JLabel("New Flight Time");
        newtime.setBounds(8, 8+20+8, 150, 20);
        
        tnewtime.setBounds(8+150+8,8+20+8,100,20);
        
        baccept.setBounds(130-50, 132-50, 80, 20);
        bcancel.setBounds(130+80+8-50, 132-50, 80, 20);
        
        base.setSize(435-100,200-50);
        base.add(flighttime);
        base.add(newtime);
        base.add(tnewtime);
        base.add(baccept);
        base.add(bcancel);
        
        add(base);
        setSize(base.getSize());
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        
    }
    
    public static void main(String[] args) {
        new SuspendingFlight();
    }
    
}