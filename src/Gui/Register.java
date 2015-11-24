/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Classes.Person;
import Database.DataAccess;
import java.awt.HeadlessException;
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

/**
 *
 * @author Christian
 */
public class Register extends JFrame{

    JPanel base;
    JTextField Username;
    JTextField Password;
    JTextField Re_Password;
    JTextField Jemail;
    JTextField Jphone;
    JButton Register;
    JCheckBox Accept;
    JButton Cancel;
        public Register()
    {
//        This part set the title
        super("Register");
        
//        This part create the null panel as the base        
        base = new JPanel(null);
        base.setSize(270, 250);

//        This part create the textField
        Username = new JTextField(10);
        Username.setBounds(150,8,100,20);
        Password = new JPasswordField(10);
        Password.setBounds(150,33,100,20);
        Re_Password = new JPasswordField(10);
        Re_Password.setBounds(150,58,100,20);
        Jemail = new JTextField(10);
        Jemail.setBounds(150,83,100,20);
        Jphone = new JTextField(10);
        Jphone.setBounds(150,108,100,20);
        
//        This part create Label for text
        JLabel User = new JLabel("Username");
        User.setBounds(8,8,100,20);
        JLabel Pas = new JLabel("Password");
        Pas.setBounds(8,33,100,20);
        JLabel repas = new JLabel("Re-Type Password");
        repas.setBounds(8, 58, 120, 20);
        JLabel email = new JLabel("Email");
        email.setBounds(8,83,100,20);
        JLabel phone = new JLabel("Phone");
        phone.setBounds(8,108,100,20);
        
        base.add(User);
        base.add(Username);
        base.add(Pas);
        base.add(Password);
        base.add(repas);
        base.add(Re_Password);
        base.add(email);
        base.add(Jemail);
        base.add(phone);
        base.add(Jphone);
        
//        This part add the textfield and label to the null Jpanel
        JLabel JAccept = new JLabel("Accept licence and agreement");
        JAccept.setBounds(8, 155, 200, 20);
        
//        This part create the checkbox
        Accept = new JCheckBox();
        Accept.setBounds(213, 140, 50, 50);
        
//        This part create the register button
        Register = new JButton("Register");
        Register.setBounds(10+20, 195, 100, 20);
        
        Cancel = new JButton("Cancel");
        Cancel.setBounds(120+20, 195, 100, 20);
        
        Cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LogIn();
            }
        });
        
        Register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //checking blank data
                if(Username.getText().equalsIgnoreCase("") || Password.getText().equalsIgnoreCase("") || Re_Password.getText().equalsIgnoreCase("") || Jemail.getText().equalsIgnoreCase("") || Jphone.getText().equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(null, "Data cannot be blank");
                }else if(!Password.getText().equals(Re_Password.getText())){
                    //checking password confirmation
                    JOptionPane.showMessageDialog(null, "Wrong password confirmation");
                }else if(!Accept.isSelected()){
                    //checking checkbox of lincese and agreement
                    JOptionPane.showMessageDialog(null, "Please accept our lincese and agreement");
                }else{
                    Person pers = new Person();
                    pers.setUsername(Username.getText());
                    pers.setPassword(Password.getText());
                    pers.setTelp(Jphone.getText());
                    pers.setEmail(Jemail.getText());
                    pers.setCurrentFCode(null);
                    DataAccess.addPassanger(pers);
                    dispose();
                    new LogIn();
                }
            }
        });
        
//        This part add the checkbox and button to the base
        base.add(JAccept);
        base.add(Accept);
        base.add(Register);
        base.add(Cancel);
        
//        this part set the frame
        setResizable(false);
        setSize(base.getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(base);
    }
        
    public static void main(String[] args) {
        new Register();
    }
}