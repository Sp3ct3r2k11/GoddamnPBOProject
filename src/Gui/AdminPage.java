package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
    JButton bcancel = new JButton("Cancel");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    
    public AdminPage(){
    
        badd.setBounds(8, 8, 70, 20);
        bsearch.setBounds(208-4, 8, 75, 20);
        bpostpone.setBounds(8, 405, 90, 30);
        
        search.setBounds(86,8,110,20);
        
        table.setBounds(300, 58, 300, table.getRowHeight());
        
        logout.add(blogout);
        logout.setBounds(795, 8, 80, 30);
        
        bcancel.setBounds(106, 405, 90, 30);
        
        base.setSize(900, 500);
        base.add(logout);
        base.add(badd);
        base.add(search);
        base.add(bsearch);
        base.add(bpostpone);
        base.add(table);
        base.add(bcancel);
        
        setResizable(false);
        setSize(base.getSize());
        add(base);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new AdminPage();
    }
    
}
