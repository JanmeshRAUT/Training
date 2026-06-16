package Queue.PriorityQueue;

public class Aircraft {
    private String flightNumber;
    private String airline;
    private String destination;
    private int priority;

    public Aircraft(String flightNumber, String airline, String destination, int priority) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.destination = destination;
        this.priority = priority;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "flightNumber='" + flightNumber + '\'' +
                ", airline='" + airline + '\'' +
                ", destination='" + destination + '\'' +
                ", priority=" + priority +
                '}';
    }
}
