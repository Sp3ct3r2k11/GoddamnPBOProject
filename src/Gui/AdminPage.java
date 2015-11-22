package gui;

import Classes.Flight;
import Database.DataAccess;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminPage extends JFrame{

    JPanel base = new JPanel(null);
    JPanel logout = new JPanel(new GridLayout(1,1));
    JButton blogout = new JButton("Logout");
    JButton badd = new JButton("Add");
    JTextField search = new JTextField(10);
    JButton bsearch = new JButton("Search");
    JButton bpostpone = new JButton("Postpone");
    JButton bcancel = new JButton("Cancel Flight");
    JScrollPane spTable;
    JTable table = new JTable();
    Object[][] arrObj; 
    String [] tableTitle = {"Flight Code","Plane Code","Plane Name","Destination","Flight Time","Status","Price"};
    Flight f = new Flight();
    
    
    public AdminPage(){
        setTitle("Admin");
        
        badd.setBounds(8, 8, 70, 20);
        bsearch.setBounds(208-4, 8, 75, 20);
        bpostpone.setBounds(8, 405, 90, 30);
        
        bpostpone.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCode = new String();
                if(table.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(null, "Please Select a Flight first!", "ERROR", 2);
                }else{
                    selectedCode = (String)table.getModel().getValueAt(table.getSelectedRow(), 0);
                    System.out.println(selectedCode);
                    f=DataAccess.getFlight(selectedCode);
                    SuspendingFlight.getFlight(f.getFlightCode(), f.getPlaneCode(), f.getPlaneName(), f.getDestination(), f.getFlightTime(), f.getStatus(), f.getPrice());
                    dispose();
                    new SuspendingFlight();
                }
            }
        });
        
        badd.addActionListener(new ActionListener() {
            // add flight button action
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Please Insert New Flight");
                dispose();
                new Add();
            }
        });
        
        search.setBounds(86,8,110,20);
        
        spTable = new JScrollPane(table);
        spTable.setBounds(30, 58, 700, 300);
        showTable(DataAccess.showflightAdmin());
        
        table.getSelectedRow();
        
        logout.add(blogout);
        logout.setBounds(795, 8, 80, 30);
        blogout.addActionListener(new ActionListener() {
            // logout button action
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Admin Logout!");
                dispose();
                new LogIn();
            }
        });
        
        bcancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCode = new String();
                if(table.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(null, "No Flight Selected!", "ERROR!", 2);
                }else{
                    selectedCode = (String)table.getModel().getValueAt(table.getSelectedRow(), 0);
                    String selectedStatus = new String();
                    selectedStatus = (String)table.getModel().getValueAt(table.getSelectedRow(), 5);
                    if(selectedStatus.equals("canceled")){
                        JOptionPane.showMessageDialog(null, "The Flight Already Canceled!","ERROR!",2);
                    }else if(selectedStatus.equals("take_off")){
                        JOptionPane.showMessageDialog(null,"The Flight has Taken Off!","ERROR",2);
                    }else{
                        int pil=JOptionPane.showConfirmDialog(null, "Are you sure to Cancel this flight?","Confirmation",0);
                        if(pil==0){
                            DataAccess.cancel(selectedCode);
                            dispose();
                            new AdminPage();
                        }
                    }
                }
            }
        });
        
        bcancel.setBounds(106, 405, 120, 30);       
        base.setSize(900, 500);
        base.add(logout);
        base.add(badd);
        base.add(search);
        base.add(bsearch);
        base.add(bpostpone);
        base.add(spTable);
        base.add(bcancel);
        
        setResizable(false);
        setSize(base.getSize());
        add(base);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
//    public static void main(String[] args) {
//        new AdminPage();
//    }
    
    private void showTable(List<Flight> listFlight){
        
        arrObj = new Object[listFlight.size()][7];
        int i = 0 ;
        for(Flight flght : listFlight){
            arrObj[i][0] = flght.getFlightCode();
            arrObj[i][1] = flght.getPlaneCode();
            arrObj[i][2] = flght.getPlaneName();
            arrObj[i][3] = flght.getDestination();
            arrObj[i][4] = flght.getFlightTime();
            arrObj[i][5] = flght.getStatus();
            arrObj[i][6] = flght.getPrice();
            i++;
        }
        
        DefaultTableModel dtm = new DefaultTableModel(arrObj,tableTitle);
        table.setModel(dtm);
        spTable.setViewportView(table);
    }
    
}