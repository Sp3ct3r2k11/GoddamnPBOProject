
package Classes;


public class Flight {
    private String FlightCode;
    private String PlaneCode;
    private String PlaneName;
    private String Destination;
    private String FlightTime;
    private String Status;
    private int price;

    public Flight() {
    }
    
    public Flight(String FlightCode, String PlaneCode, String PlaneName, String Destination, String FlightTime, String Status, int price) {
        this.FlightCode = FlightCode;
        this.PlaneCode = PlaneCode;
        this.PlaneName = PlaneName;
        this.Destination = Destination;
        this.FlightTime = FlightTime;
        this.Status = Status;
        this.price = price;
    }

    public String getFlightCode() {
        return FlightCode;
    }

    public void setFlightCode(String FlightCode) {
        this.FlightCode = FlightCode;
    }

    public String getPlaneCode() {
        return PlaneCode;
    }

    public void setPlaneCode(String PlaneCode) {
        this.PlaneCode = PlaneCode;
    }

    public String getPlaneName() {
        return PlaneName;
    }

    public void setPlaneName(String PlaneName) {
        this.PlaneName = PlaneName;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public String getFlightTime() {
        return FlightTime;
    }

    public void setFlightTime(String FlightTime) {
        this.FlightTime = FlightTime;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
}
