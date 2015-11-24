
package Database;

import Classes.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
public class DataAccess {
    
    //data access flight
    
    public static List<Flight> showflightUser(){
        List<Flight> flght = new ArrayList<Flight>();
        String query = "SELECT code,planecode,planename,destination,flighttime,ticketprice FROM flight WHERE status='ready' or status='delayed' ORDER BY flighttime";
        
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
    
    public static List<Flight> showSearchUser(String like){
        List<Flight> flght = new ArrayList<Flight>();
        String query = "SELECT code,planecode,planename,destination,flighttime,ticketprice FROM flight WHERE destination LIKE ? and status='ready' or destination LIKE ? and status='delayed' ORDER BY flighttime";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection().
                                    prepareStatement(query);
            st.setString(1, like);
            st.setString(2, like);
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
        String query = "SELECT * FROM flight ORDER BY flighttime";
        
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
    
    public static List<Flight> showSearchAdmin(String like){
        List<Flight> flght = new ArrayList<Flight>();
        String query = "SELECT * FROM flight WHERE destination LIKE ? ORDER BY flighttime";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection().
                                    prepareStatement(query);
            st.setString(1, like);
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
    
    public static Timestamp selectingNearestFlight(){
        Timestamp date = null;
        Calendar time=Calendar.getInstance();
        String query = "SELECT flighttime FROM flight WHERE status = 'ready' or status = 'delayed' ORDER BY flighttime";
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            ResultSet rs = st.executeQuery();
            rs.next();
            date=rs.getTimestamp(1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    
    public static void TakeOff(){
        String query = "SELECT code FROM flight WHERE status = 'ready' or status = 'delayed' ORDER BY flighttime";
        String code = new String();
        try {
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            ResultSet rs = st.executeQuery();
            rs.next();
            code = rs.getString(1);
            
            String query2 = "UPDATE flight SET status='take_off' WHERE code=?";
            PreparedStatement st2 = ConnectionManager.getConnection().prepareStatement(query2);
            st2.setString(1, code);
            st2.execute();
            //JOptionPane.showMessageDialog(null, "The flight "+code+" has taken off!");
            System.out.println("The flight "+code+" has taken off!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void cancel(String flightId){
        String query = "UPDATE flight SET status='canceled' WHERE code=?";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection()
                                        .prepareStatement(query);
            st.setString(1, flightId);
            st.execute();
            JOptionPane.showMessageDialog(null, "The Flight "+flightId+" has canceled!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void postpone(String newTime,String flightId){
        String query1 = "UPDATE flight SET flighttime=? WHERE code=?";
        String query2 = "UPDATE flight SET status='delayed' WHERE code=?";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection()
					.prepareStatement(query1);
            st.setString(1, newTime);
            st.setString(2, flightId);
            st.execute();
            
            PreparedStatement st2 = ConnectionManager.getConnection()
                                        .prepareStatement(query2);
            st2.setString(1, flightId);
            st2.execute();
            
            JOptionPane.showMessageDialog(null, "Flight Delayed!");
        } catch (Exception e) {
            System.out.println("Wrong date & time format!");
            JOptionPane.showMessageDialog(null, "Wrong date & time Format!", "ERROR!",2);
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
    
    public static Flight getFlight(String code){
        Flight f = new Flight();
        String query = "SELECT * FROM flight WHERE code=?";
        try {
            PreparedStatement st = ConnectionManager.getConnection()
                                    .prepareStatement(query);
            st.setString(1, code);
            ResultSet rs = st.executeQuery();
            rs.next();
            f.setFlightCode(rs.getString(1));
            f.setPlaneCode(rs.getString(2));
            f.setPlaneName(rs.getString(3));
            f.setDestination(rs.getString(4));
            f.setFlightTime(rs.getString(5));
            f.setStatus(rs.getString(6));
            f.setPrice(rs.getInt(7));
        } catch (Exception e) {
            System.out.println("Flight Not Found!");
            JOptionPane.showMessageDialog(null, "Flight Not Found!","Error!",2);
        }
        return f;
    } 
    
    //data access passanger
    
    public static Person getPassangerData(String username,String password){
        Person p = new Person();
        String query = "SELECT * FROM person WHERE name=? and pass=?";
        try {
            PreparedStatement st = ConnectionManager.getConnection()
                                    .prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            rs.next();  
            p.setUsername(rs.getString(1)); 
            p.setPassword(rs.getString(2));
            p.setEmail(rs.getString(3)); 
            p.setTelp(rs.getString(4));
            p.setCurrentFCode(rs.getString(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    
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
            System.out.println("Username & Password not Found!");
            return false;
        }
    }
    
    public static void setFlightCode(String name,String pass,String newFlightCode){
        String query = "UPDATE person SET current_fcode=? WHERE name=? and pass=?";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection()
                                        .prepareStatement(query);
            st.setString(1, newFlightCode);
            st.setString(2, name);
            st.setString(3, pass);
            st.execute();
            System.out.println("Flight Code Changed!");
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
