
package Database;

import Classes.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
public class DataAccess {
    
    //data access flight
    
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
            
            Person p = new Person();
            p.setId(rs.getString(1)); 
            p.setUsername(rs.getString(2)); 
            p.setPassword(rs.getString(3));
            p.setEmail(rs.getString(4)); 
            p.setTelp(rs.getString(5));
            p.setCurrentFCode(rs.getString(6));
            
            if(p.getId() == null){
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
    
    public static void changePassword(String id,String newPass){
        String query = "UPDATE person SET pass=? WHERE id=?";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection()
                                        .prepareCall(query);
            st.setString(1, newPass);
            st.setString(2, id);
            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void addPassanger(Person prsn){
        String query = "INSERT INTO person VALUES(?,?,?,?,?,?)";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection()
                                        .prepareStatement(query);
            st.setString(1, prsn.getId());
            st.setString(2, prsn.getUsername());
            st.setString(3, prsn.getPassword());
            st.setString(4, prsn.getEmail());
            st.setString(5, prsn.getTelp());
            st.setString(6, prsn.getCurrentFCode());
            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}
