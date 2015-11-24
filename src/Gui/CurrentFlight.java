/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Classes.Flight;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    static Flight flight;
    
    public CurrentFlight() {
        super("Current Flight");
                
        base = new JPanel(null);
        base.setSize(270, 250);

//        This part create the textField
        
        
//        This part create Label for text
        JLabel flightCode = new JLabel("Flight Code : \t"+flight.getFlightCode());
        flightCode.setBounds(8,8,250,20);
        JLabel planeCode = new JLabel("Plane Code : \t"+flight.getPlaneCode());
        planeCode.setBounds(8,33,250,20);
        JLabel planeName = new JLabel("Plane Name : \t"+flight.getPlaneName());
        planeName.setBounds(8, 58, 250, 20);
        JLabel destination = new JLabel("Destination : \t"+flight.getDestination());
        destination.setBounds(8,83,250,20);
        JLabel flightTime = new JLabel("Flight Time : \t"+flight.getFlightTime());
        flightTime.setBounds(8,108,250,20);
        JLabel status = new JLabel("Status : \t"+flight.getStatus());
<<<<<<< HEAD
        status.setBounds(8,108+25,250,20);
=======
        status.setBounds(8,108+(108-83),250,20);
>>>>>>> 83cd4b4cb31dfae454d023423acf4665ec94925f
        JLabel price = new JLabel("Price : \t"+flight.getPrice());
        price.setBounds(8,161+(108-83)*2,250,20);
        
        base.add(flightCode);
        base.add(planeCode);
        base.add(planeName);
        base.add(destination);
        base.add(flightTime);
        base.add(status);
        base.add(price);
              
//        This part create the register button
        bOke = new JButton("OK");
        bOke.setBounds(8+8, 195, 110, 20);
        
        bOke.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Passanger();
            }
        });
        
        bcancel = new JButton("Cancel Flight");
        bcancel.setBounds(80-50+110, 195, 100+10, 20);
        
        bcancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int pil = JOptionPane.showConfirmDialog(null, "Are you sure to Cancel this Flight?", "Confirmation", 0);
                if(pil == 0){
                    String name = Passanger.passanger.getUsername();
                    String pass = Passanger.passanger.getPassword();
                    Database.DataAccess.setFlightCode(name, pass, null);
                    JOptionPane.showMessageDialog(null, "Flight Canceled!", "Message", 1);
                    Passanger.passanger.setCurrentFCode("-");
                    dispose();
                    new Passanger();
                }
            }
        });
        
//        This part add the button to the base
        base.add(bcancel);
        base.add(bOke);
        
//        this part set the frame
        setResizable(false);
        setSize(base.getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(base);
    }
    
    public static void main(String[] args) {
        new CurrentFlight();
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
    
}