/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Classes.Flight;
import Database.DataAccess;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    JTextField tnewtime = new JTextField("YYYY-MM-DD HH:MM:SS");
    
    static Flight flight;
    
    public SuspendingFlight(){
        super("Suspend Flight");
        
        JLabel flighttime = new JLabel("Currrent Flight Time : " + flight.getFlightTime());
        flighttime.setBounds(8, 8, 250, 20);
        JLabel newtime = new JLabel("New Flight Time");
        newtime.setBounds(8, 8+20+8, 150, 20);
        
        tnewtime.setBounds(8+150,8+20+8,150,20);
        
        baccept.setBounds(130-50, 132-50, 80, 20);
        bcancel.setBounds(130+80+8-50, 132-50, 80, 20);
        
        baccept.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String newTime = new String();
                newTime = tnewtime.getText();
                if(newTime.equals("") || newTime.equals("YYYY-MM-DD HH:MM:SS")){
                    JOptionPane.showMessageDialog(null, "New time must be inserted!", "Error!", 2);
                }else{
                    DataAccess.postpone(newTime, flight.getFlightCode());
                    dispose();
                    new AdminPage();
                }
            }
        });
        
        bcancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminPage();
            }
        });
        
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
    
    public static void getFlight(String a,String b, String c, String d, String e, String f, int g){
        flight = new Flight();
        flight.setFlightCode(a);
        flight.setPlaneCode(b);
        flight.setPlaneName(c);
        flight.setDestination(d);
        flight.setFlightTime(e);
        flight.setStatus(f);
        flight.setPrice(g);
    }
    
    public static void main(String[] args) {
        new SuspendingFlight();
    }
    
}