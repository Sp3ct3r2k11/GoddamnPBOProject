
package gui;

import Database.*;
import Classes.*;
import Gui.CountDown;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JFrame{

    Person p = new Person();
    JPanel base;
    JTextField username;
    JTextField password;
    JButton login;
    JButton register;
    static Gui.CountDown hitung = new Gui.CountDown();
    public LogIn() 
    {
//        This is the title of this Frame  
        super("Login");
        
//        This part create the null panel as the base
        base = new JPanel(null);
        base.setSize(250, 122);
        
//        This part make thread
        Thread thread = new Thread(hitung);
        thread.start();
        
//        This part create the textField
        username = new JTextField(10);
        username.setBounds(135,8,100,20);
        password = new JPasswordField(10);
        password.setBounds(135,33,100,20);
        
//        This part create buttons
        login = new JButton("Login");
        login.setBounds(20, 65, 100, 20);
        register = new JButton("Register");
        register.setBounds(125, 65, 100, 20);
        
        register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Welcome our new member!");
                dispose();
                new Register();
            }
        });
        
//        This part for calling button action listener
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getUsername = username.getText();
                String getPassword = password.getText();
                
                if(getUsername.equals("admin")&&getPassword.equals("admin123")){
                    JOptionPane.showMessageDialog(null, "Admin Login Success!");
                    new AdminPage();
                    dispose();
                }
                else{
                    if(!DataAccess.getPassanger(getUsername, getPassword)){
                        JOptionPane.showMessageDialog(null, "Login Failed! Please insert a correct Username and Password!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Login Success!\n Login As : "+getUsername);
                        p=DataAccess.getPassangerData(getUsername, getPassword);
                        System.out.println(p.getUsername()+p.getPassword());
                        Passanger.getUser(p.getUsername(),p.getPassword(),p.getEmail(),p.getTelp(),p.getCurrentFCode());
                        dispose();
                        new Passanger();
                    }
                }
            }
        });
        
//        This part create Label for text
        JLabel user = new JLabel("Username");
        user.setBounds(8,8,100,20);
        JLabel pas = new JLabel("Password");
        pas.setBounds(8,33,100,20);
        
//        This part add the textfield, buttons and label to the null Jpanel
        base.add(user);
        base.add(username);
        base.add(pas);
        base.add(password);
        
        base.add(login);
        base.add(register);
        
//        This part set the size by looking the null panel as the base etc.
        setSize(base.getSize());
        setResizable(false);
        add(base);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static CountDown getHitung() {
        return hitung;
    }

    public static void setHitung(CountDown hitung) {
        LogIn.hitung = hitung;
    }
    
    public static void main(String[] args) {
        new LogIn();
    }

    
    
    
}