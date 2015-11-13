
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Christian
 */
public class Add extends JFrame{
    
    JPanel base;
    JTextField jFlightCode;
    JTextField jPlaneCode;
    JTextField jPlaneName;
    JTextField jDestination;
    JTextField jFlightTime;
    JTextField jPrice;
    JButton baccept;
    JButton bcancel;

    public Add() {
        super("Add Flight");
                
        base = new JPanel(null);
        base.setSize(270, 250);

//        This part create the textField
        jFlightCode = new JTextField(10);
        jFlightCode.setBounds(150,8,100,20);
        jPlaneCode = new JTextField(10);
        jPlaneCode.setBounds(150,33,100,20);
        jPlaneName = new JTextField(10);
        jPlaneName.setBounds(150,58,100,20);
        jDestination = new JTextField(10);
        jDestination.setBounds(150,83,100,20);
        jFlightTime = new JTextField(10);
        jFlightTime.setBounds(150,108,100,20);
        jPrice = new JTextField(10);
        jPrice.setBounds(150, 108+(33-8), 100, 20);
        
//        This part create Label for text
        JLabel flightCode = new JLabel("Flight Code");
        flightCode.setBounds(8,8,100,20);
        JLabel planeCode = new JLabel("Plane Code");
        planeCode.setBounds(8,33,100,20);
        JLabel planeName = new JLabel("Plane Name");
        planeName.setBounds(8, 58, 120, 20);
        JLabel destination = new JLabel("Destination");
        destination.setBounds(8,83,100,20);
        JLabel flightTime = new JLabel("Flight Time");
        flightTime.setBounds(8,108,100,20);
        JLabel price = new JLabel("Price");
        price.setBounds(8, 108+(33-8), 100, 20);
        
        base.add(flightCode);
        base.add(jFlightCode);
        base.add(planeCode);
        base.add(jPlaneCode);
        base.add(planeName);
        base.add(jPlaneName);
        base.add(destination);
        base.add(jDestination);
        base.add(flightTime);
        base.add(jFlightTime);
        base.add(jPrice);
        base.add(price);
              
        
//        This part create the register button
        baccept = new JButton("Accept");
        baccept.setBounds(80-50, 195, 100, 20);
        bcancel = new JButton("Cancel");
        bcancel.setBounds(80-50+100+8, 195, 100, 20);
        
//        This part add the checkbox and button to the base
        base.add(bcancel);
        base.add(baccept);
        
//        this part set the frame
        setResizable(false);
        setSize(base.getSize());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        add(base);
    }
    
    public static void main(String[] args) {
        new Add();
    }
    
}