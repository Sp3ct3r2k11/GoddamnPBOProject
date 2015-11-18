package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Passanger extends JFrame{
    
    JPanel base = new JPanel(null);
    JPanel logout = new JPanel(new GridLayout(1,1));
    JButton blogout = new JButton("Logout");
    JButton bProfile = new JButton("Profile");
    JTextField search = new JTextField(10);
    JButton bsearch = new JButton("Search");
    JButton bCurrentFlight = new JButton("Current Flight");
    JButton bBook = new JButton("Book");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    
    public Passanger(){
        
        setTitle("Passanger");
        
        bProfile.setBounds(8, 8, 70+5, 20);
        bsearch.setBounds(8+110+8, 8+20+8, 75, 20);
        bCurrentFlight.setBounds(8+70+5+8, 8, 120, 20);
        
        search.setBounds(8,8+20+8,110,20);
        
        table.setBounds(8, 58+8, 900-200, table.getRowHeight());
        
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
        
        base.setSize(900-150, 500);
        base.add(logout);
        base.add(bProfile);
        base.add(search);
        base.add(bsearch);
        base.add(bCurrentFlight);
        base.add(table);
        base.add(bBook);
        
        setResizable(false);
        setSize(base.getSize());
        add(base);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Passanger();
    }
}