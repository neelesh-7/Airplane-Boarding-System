package LA5Q;

import java.util.ArrayList;
import java.util.Arrays;

public class Airplane {

    // ArrayList of letters so we can map a seat letter (A–F) to a column index with indexOf (linear list)
    private ArrayList<String> letters = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F"));

    // Seating layout is a fixed 20x6 grid, so a 2D array is ideal: constant-time access by row and column
    public Passenger[][] passengers;

    // Set up a fixed seating layout: 20 rows and 6 seats per row
    public Airplane() {
        this.passengers = new Passenger[20][6];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 6; j++) {
                passengers[i][j] = new Passenger(); // Each element of the 2D array holds a Passenger object representing a single seat
            }
        }
    }

    // Board a single passenger at a specific seat
    public void boardPassenger(String columnLetter, int rowNumber) {
        // ArrayList gives us simple letter -> index conversion while still being a linear data structure
        int columnIndex = letters.indexOf(columnLetter.toUpperCase());
        if (passengers[rowNumber - 1][columnIndex].getPassengerState().equals("X")) {
            System.out.println("That seat is already occupied.");
        } else {
            System.out.printf("Passenger boarded at seat %s%d.%n",
                    columnLetter.toUpperCase(), rowNumber);
            passengers[rowNumber - 1][columnIndex].boardPassenger();
        }
    }

    // Remove a passenger from a specific seat
    public void disembarkPassenger(String columnLetter, int rowNumber) {
        int columnIndex = letters.indexOf(columnLetter.toUpperCase());
        if (passengers[rowNumber - 1][columnIndex].getPassengerState().equals("-")) {
            System.out.println("That seat is already empty.");
        } else {
            System.out.printf("Passenger disembarked from seat %s%d.%n",
                    columnLetter.toUpperCase(), rowNumber);
            passengers[rowNumber - 1][columnIndex].disembarkPassenger();
        }
    }

    // Clear every seat on the airplane
    public void disembarkAll() {
        // Nested loops over the 2D array let us touch every seat in a simple, row-by-row linear fashion
        for (int i = 0; i < passengers.length; i++) {
            for (int j = 0; j < passengers[i].length; j++) {
                passengers[i][j].disembarkPassenger();
            }
        }
        System.out.println("All seats have been cleared.");
    }

    // Fill every seat on the airplane
    public void boardAll() {
        for (int i = 0; i < passengers.length; i++) {
            for (int j = 0; j < passengers[i].length; j++) {
                passengers[i][j].boardPassenger();
            }
        }
        System.out.println("Every seat has been filled with a passenger.");
    }

    // Display the current seating chart by looping through the 2D array
    public void printSeats() {
        System.out.println("\nCurrent seat map (X = occupied):");
        System.out.println("     A  B  C   D  E  F");
        for (int i = 0; i < passengers.length; i++) {

            // Format row numbers so the grid lines up nicely
            if (i < 9) {
                System.out.printf(" %d [", i + 1);
            } else {
                System.out.printf("%d [", i + 1);
            }

            for (int j = 0; j < passengers[i].length; j++) {
                // Extra space after column C to visually separate left and right sides of the aisle
                if (j == 2) {
                    System.out.print(passengers[i][j] + " ");
                } else {
                    System.out.print(passengers[i][j]);
                }
            }
            System.out.println("]");
        }
        System.out.println();
    }
}
