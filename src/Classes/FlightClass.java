package Classes;

public class Flight {
    
    private String flightCode;
    private String planeCode;
    private String planeName;
    private String destination;
    private String flighTtime;
    private String estimatedArrival;

    public Flight() {
    }

    public Flight(String flightCode, String planeCode, String planeName, String destination, String flighTtime, String estimatedArrival) {
        this.flightCode = flightCode;
        this.planeCode = planeCode;
        this.planeName = planeName;
        this.destination = destination;
        this.flighTtime = flighTtime;
        this.estimatedArrival = estimatedArrival;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getPlaneCode() {
        return planeCode;
    }

    public void setPlaneCode(String planeCode) {
        this.planeCode = planeCode;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlighTtime() {
        return flighTtime;
    }

    public void setFlighTtime(String flighTtime) {
        this.flighTtime = flighTtime;
    }

    public String getEstimatedArrival() {
        return estimatedArrival;
    }

    public void setEstimatedArrival(String estimatedArrival) {
        this.estimatedArrival = estimatedArrival;
    }
    
}
