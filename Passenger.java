package LA5Q;

public class Passenger {

    private String state; // We store the seat status as a one-character String ("-" or "X") so it prints cleanly in the seat grid

    // When a Passenger object is created, the seat starts off as empty
    Passenger() {
        state = "-";
    }

    // Marks the seat as taken by switching the state to "X"
    public void boardPassenger() {
        state = "X";
    }

    // Returns the current status of the seat
    public String getPassengerState() {
        return state;
    }

    // Resets the seat back to empty when the passenger gets off
    public void disembarkPassenger() {
        state = "-";
    }

    @Override
    public String toString() {
        // Wrap the state in brackets to make the seating layout easier to read visually
        return String.format("[%s]", state);
    }
}
