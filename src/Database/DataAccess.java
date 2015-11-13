
package Database;

import Classes.*;
import java.sql.PreparedStatement;
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
        String query = "INSERT INTO flight VALUES(?,?,?,?,?,?)";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection()
                                    .prepareStatement(query);
            st.setString(1, flght.getFlightCode());
            st.setString(2, flght.getPlaneCode());
            st.setString(3, flght.getPlaneName());
            st.setString(4, flght.getDestination());
            st.setString(4, flght.getFlightTime());
            st.setString(5, "Waiting");
	    st.execute();
        } catch (Exception e) {
            e.printStackTrace();
	}
    }
    
    //data access passanger
    
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
    
    //data access flight_history
    
    public static void addHistory(Person prsn, Flight flght){
        String query = "INSERT INTO flight_history VALUES(?,?)";
        
        try {
            PreparedStatement st = ConnectionManager.getConnection()
                                        .prepareStatement(query);
            st.setString(1, prsn.getId());
            st.setString(2, flght.getFlightCode());
            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
