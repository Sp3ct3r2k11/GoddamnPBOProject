
package Database;

import Classes.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class DataAccess {
    
    //data access flight
    
    public static List<Flight> showflightUser(){
        List<Flight> flght = new ArrayList<Flight>();
        String query = "SELECT code,planecode,planename,destination,flighttime,ticket_price FROM flight WHERE status='ready'";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection().
                                    prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Flight f = new Flight();
                f.setFlightCode(rs.getString(1));
                f.setPlaneCode(rs.getString(2));
                f.setPlaneName(rs.getString(3));
                f.setDestination(rs.getString(4));
                f.setFlightTime(rs.getString(5));
                f.setPrice(rs.getInt(6));
                flght.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flght;
    }
    
    public static List<Flight> showflightAdmin(){
        List<Flight> flght = new ArrayList<Flight>();
        String query = "SELECT * FROM flight";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection().
                                    prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Flight f = new Flight();
                f.setFlightCode(rs.getString(1));
                f.setPlaneCode(rs.getString(2));
                f.setPlaneName(rs.getString(3));
                f.setDestination(rs.getString(4));
                f.setFlightTime(rs.getString(5));
                f.setStatus(rs.getString(6));
                f.setPrice(rs.getInt(7));
                flght.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flght;
    }
    
    public static void postpone(String newTime,String flightId){
        String query = "UPDATE flight SET flighttime=? WHERE code=?";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection()
					.prepareStatement(query);
            st.setString(1, newTime);
            st.setString(2, flightId);
            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void addFlight(Flight flght){
        String query = "INSERT INTO flight VALUES(?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection()
                                    .prepareStatement(query);
            st.setString(1, flght.getFlightCode());
            st.setString(2, flght.getPlaneCode());
            st.setString(3, flght.getPlaneName());
            st.setString(4, flght.getDestination());
            st.setString(5, flght.getFlightTime());
            st.setString(6, flght.getStatus());
            st.setInt(7, flght.getPrice());
	    st.execute();
            JOptionPane.showMessageDialog(null, "Flight Successfully Added!");
        } catch (Exception e) {
            e.printStackTrace();
	}
    }
    
    //data access passanger
    
    public static boolean getPassanger(String username,String password){
        String query = "SELECT * FROM person WHERE name=? and pass=?";
        try {
            PreparedStatement st = ConnectionManager.getConnection()
                                    .prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            rs.next();
            Person p = new Person();
            p.setUsername(rs.getString(1)); 
            p.setPassword(rs.getString(2));
            p.setEmail(rs.getString(3)); 
            p.setTelp(rs.getString(4));
            p.setCurrentFCode(rs.getString(5));
            
            if(p.getUsername()== null){
                return false;
            }else{
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void setFlightCode(String id,String newFlightCode){
        String query = "UPDATE person SET current_fcode=? WHERE id=?";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection()
                                        .prepareCall(query);
            st.setString(1, newFlightCode);
            st.setString(2, id);
            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void addPassanger(Person prsn){
        String query = "INSERT INTO person VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection()
                                        .prepareStatement(query);
            st.setString(1, prsn.getUsername());
            st.setString(2, prsn.getPassword());
            st.setString(3, prsn.getEmail());
            st.setString(4, prsn.getTelp());
            st.setString(5, prsn.getCurrentFCode());
            st.execute();
            JOptionPane.showMessageDialog(null, "Register Succesfull!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}
