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
public class CurrentFlight extends JFrame{
    JPanel base;
    JButton bOke;
    JButton bcancel;

    public CurrentFlight() {
        super("Current Flight");
                
        base = new JPanel(null);
        base.setSize(270, 250);

//        This part create the textField
        
        
//        This part create Label for text
        JLabel passID = new JLabel("Pass ID");
        passID.setBounds(8,8,100,20);
        JLabel flightCode = new JLabel("Flight Code");
        flightCode.setBounds(8,33,100,20);
        JLabel flightTime = new JLabel("Flight Time");
        flightTime.setBounds(8, 58, 120, 20);
        JLabel destination = new JLabel("Destination");
        destination.setBounds(8,83,100,20);
        JLabel price = new JLabel("Price Total");
        price.setBounds(8,108,100,20);
        
        base.add(passID);
        base.add(flightCode);
        base.add(flightTime);
        base.add(destination);
        base.add(price);
              
//        This part create the register button
        bOke = new JButton("OK");
        bOke.setBounds(80-50, 195, 70, 20);
        bcancel = new JButton("Cancel Flight");
        bcancel.setBounds(80-50+70+8, 195, 100+20, 20);
        
//        This part add the checkbox and button to the base
        base.add(bcancel);
        base.add(bOke);
        
//        this part set the frame
        setResizable(false);
        setSize(base.getSize());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        add(base);
    }
    
    public static void main(String[] args) {
        new CurrentFlight();
    }
    
        
}