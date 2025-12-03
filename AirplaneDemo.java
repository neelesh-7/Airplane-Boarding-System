package LA5Q;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AirplaneDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome aboard!");

        // Create a new airplane object to track seats
        Airplane airplane = new Airplane();
        airplane.printSeats();

        // Main loop that keeps the menu running until the user chooses to exit
        while (running) {
            printOptions();

            try {
                System.out.print("Choose an option (1–6): ");
                int option = input.nextInt();

                if (option < 1 || option > 6) {
                    throw new InputMismatchException();
                }

                // Handle the selected menu option
                switch (option) {

                    case 1:
                        // Fill every seat with a passenger
                        airplane.boardAll();
                        break;

                    case 2:
                        // Empty all seats
                        airplane.disembarkAll();
                        break;

                    case 3:
                        // Board one specific seat—validate seat letter & number
                        while (true) {
                            System.out.print("Enter seat to board (Example: A1): ");
                            String boardSeat = input.next();
                            int seatNumber;

                            // Check that the first character is a valid seat letter (A–F)
                            char seatLetter = boardSeat.charAt(0);
                            if (!Character.isLetter(seatLetter) ||
                                    Character.toUpperCase(seatLetter) < 'A' ||
                                    Character.toUpperCase(seatLetter) > 'F') {
                                System.out.println("Seat must start with a letter between A and F.");
                                continue;
                            }

                            // Ensure the number part is valid (1–20)
                            try {
                                seatNumber = Integer.parseInt(boardSeat.substring(1));
                                if (seatNumber < 1 || seatNumber > 20) {
                                    throw new Exception();
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Seat must be written as Letter + Number (e.g., B4).");
                                continue;
                            } catch (Exception e) {
                                System.out.println("Seat number must be from 1 to 20.");
                                continue;
                            }

                            // Board that specific seat
                            airplane.boardPassenger(boardSeat.substring(0, 1), seatNumber);
                            break;
                        }
                        break;

                    case 4:
                        // Remove a passenger from a specific seat (same validation as above)
                        while (true) {
                            System.out.print("Enter seat to disembark (Example: A1): ");
                            String disembarkSeat = input.next();
                            int seatNumber;

                            char seatLetter = disembarkSeat.charAt(0);
                            if (!Character.isLetter(seatLetter) ||
                                    Character.toUpperCase(seatLetter) < 'A' ||
                                    Character.toUpperCase(seatLetter) > 'F') {
                                System.out.println("Seat must start with a letter between A and F.");
                                continue;
                            }

                            try {
                                seatNumber = Integer.parseInt(disembarkSeat.substring(1));
                                if (seatNumber < 1 || seatNumber > 20) {
                                    throw new Exception();
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Seat must be written as Letter + Number (e.g., C7).");
                                continue;
                            } catch (Exception e) {
                                System.out.println("Seat number must fall between 1 and 20.");
                                continue;
                            }

                            // Disembark that one passenger
                            airplane.disembarkPassenger(disembarkSeat.substring(0, 1), seatNumber);
                            break;
                        }
                        break;

                    case 5:
                        // Reprint the seating chart
                        airplane.printSeats();
                        break;

                    case 6:
                        System.out.println("Thank you for flying with us!");
                        running = false;
                        break;
                }

            } catch (InputMismatchException e) {
                // Handle any input that isn't an integer
                input.nextLine();
                System.out.println("Invalid entry. Please enter a number.\n");
            }
        }
    }

    // Prints the menu of available actions
    public static void printOptions() {
        System.out.println("Menu Options:");
        System.out.println("1. Board Every Seat");
        System.out.println("2. Empty All Seats");
        System.out.println("3. Board an Individual Seat");
        System.out.println("4. Empty an Individual Seat");
        System.out.println("5. Show Seating Layout");
        System.out.println("6. Quit Program");
    }
}


