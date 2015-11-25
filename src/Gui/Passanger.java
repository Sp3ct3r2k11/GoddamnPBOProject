package gui;

import Classes.*;
import Database.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Passanger extends JFrame{
    
    
    static Person passanger;
    JPanel base = new JPanel(null);
    JPanel logout = new JPanel(new GridLayout(1,1));
    JButton blogout = new JButton("Logout");
    JButton bProfile = new JButton("Profile");
    JTextField search = new JTextField("Destination Search");
    JButton bsearch = new JButton("Search");
    JButton bCurrentFlight = new JButton("Current Flight");
    JButton bBook = new JButton("Book");
    
    JScrollPane spTable;
    DefaultTableModel model;
    JTable table = new JTable();
    Object[][] arrObj;
    String [] tableTitle = {"Flight Code","Plane Code","Plane Name","Destination","Flight Time","Ticket Price"};
    
    Flight f =  new Flight();
    
    public Passanger(){
        
        Gui.CountDown hitung = LogIn.getHitung();
        
        hitung.setBounds(400, 450, 350, 20);
              
        setTitle("Passanger");
        
        bProfile.setBounds(8, 8, 70+5, 20);
        bsearch.setBounds(8+110+8+100, 8+20+8, 75, 20);
        
        bsearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!search.getText().isEmpty()){
                    showTable(DataAccess.showSearchUser("%"+search.getText()+"%"));
                }else{
                    showTable(DataAccess.showflightUser());
                }
            }
        });
        
        bCurrentFlight.setBounds(8+70+5+8, 8, 120, 20);
        
        bCurrentFlight.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(passanger.getCurrentFCode().equals("-")){
                    System.out.println("No Flight Code");
                    JOptionPane.showMessageDialog(null, "You haven't book any flight!", "ERROR", 2);
                }else{
                    f=DataAccess.getFlight(passanger.getCurrentFCode());
                    CurrentFlight.getFlight(f.getFlightCode(), f.getPlaneCode(), f.getPlaneName(), f.getDestination(), f.getFlightTime(), f.getStatus(), f.getPrice());
                    System.out.println(f.getFlightCode());
                    new CurrentFlight();
                    dispose();
                }
            }
        });
        
        bProfile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Passanger Profile: \n"
                        + "Name : "+passanger.getUsername()+
                        "\n Email : "+passanger.getEmail()+
                        "\n Telp : "+passanger.getTelp()+
                        "\n Current Flight Code : "+passanger.getCurrentFCode(), "PROFILE", 1);
            }
        });
        
        search.setBounds(8,8+20+8,210,20);
        spTable = new JScrollPane(table);
        spTable.setBounds(8, 58+8, 900-200, 300);
        showTable(DataAccess.showflightUser());
        
        logout.add(blogout);
        logout.setBounds(795-150, 8, 80, 30);
        blogout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null, "User Logout");
                new LogIn();
            }
        });
        
        bBook.setBounds(8, 405, 90, 30);
        bBook.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCode = new String();
                if(table.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(null, "No Flight Selected", "ERROR!", 2);
                }else if(!passanger.getCurrentFCode().equals("-")){
                    JOptionPane.showMessageDialog(null, "You have already booking a Flight! \n"
                            + "To booking another flight please cancel the current flight!","ERROR!",2);
                }else{
                    selectedCode = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
                    System.out.println(selectedCode);
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to book : "+selectedCode+ " ?","Confirmation", 2);
                    if(confirm==0){
                        System.out.println(confirm);
                        passanger.setCurrentFCode(selectedCode);
                        DataAccess.setFlightCode(passanger.getUsername(), passanger.getPassword(), selectedCode);
                        JOptionPane.showMessageDialog(null, "Ticket Purchased!", "Information", 1);
                    }
                }      
            }
        });
        
        base.setSize(900-150, 500);
        base.add(hitung);
        base.add(logout);
        base.add(bProfile);
        base.add(search);
        base.add(bsearch);
        base.add(bCurrentFlight);
        base.add(spTable);
        base.add(bBook);
        
        setResizable(false);
        setSize(base.getSize());
        add(base);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
//    public static void main(String[] args) {
//        new Passanger();
//    }
    
    public static void getUser(String a,String b,String c,String d,String e){
        passanger = new Person();
        passanger.setUsername(a);
        passanger.setPassword(b);
        passanger.setEmail(c);
        passanger.setTelp(d);
        if(e==null){
            passanger.setCurrentFCode("-");
        }else{
            passanger.setCurrentFCode(e);
        }
        
    }
    
    private void showTable(List<Flight> listFlight){
        
        arrObj = new Object[listFlight.size()][6];
        int i = 0 ;
        for(Flight flght : listFlight){
            arrObj[i][0] = flght.getFlightCode();
            arrObj[i][1] = flght.getPlaneCode();
            arrObj[i][2] = flght.getPlaneName();
            arrObj[i][3] = flght.getDestination();
            arrObj[i][4] = flght.getFlightTime();
            arrObj[i][5] = flght.getPrice();
            i++;
        }
        
        DefaultTableModel dtm = new DefaultTableModel(arrObj,tableTitle);
        table.setModel(dtm);
        spTable.setViewportView(table);
    }
   
    

}