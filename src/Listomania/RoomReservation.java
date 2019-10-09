package Listomania;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Driver class for Room Reservations
 * TODO:
 * [3 points] Add a menu option "C" for Checkout below, which clears a reserved room to be empty and displays a message that the room is now available
 * [2 points] Implement printRoomListing method below to display a listing all the reservations in the hotelListomania ArrayList
 * [2 points] Handle the IndexOutOfBoundsException that gets thrown when the user chooses an invalid room index
 * [2 points] Fix the R (Reserve) menu choice below so that a room can only be booked if it is empty
 * [1 point ] Fix the isEmpty() method in the Room class so that it returns true only if the room is available (empty)
 */

public class RoomReservation {

    final static int NUMROOMS = 5;

    // Methods

    /**
     * Initialize all rooms in the ArrayList to empty
     *
     * @param rooms Elements of type Room in the ArrayList
     */
    public static void makeRoomsEmpty(ArrayList<Room> rooms) {

        int i;
        for (i = 0; i < rooms.size(); ++i) {
            rooms.get(i).clearRoom();
        }
    }

    /**
     * Print a listing of all room reservations to the display
     *
     * @param rooms
     */
    public static void printRoomListing(ArrayList<Room> rooms) {
        for (int i = 0; i < NUMROOMS; i++) {
            System.out.print(i + " ");
            rooms.get(i).printReservation();
        }
    }

    /**
     * Add each Room to the ArrayList
     *
     * @param rooms    Elements of type Room in the ArrayList
     * @param numRooms The number of rooms in the hotel
     */
    public static void addRooms(ArrayList<Room> rooms, int numRooms) {
        int i;
        for (i = 0; i < numRooms; ++i) {
            rooms.add(new Room());
        }
    }

    /**
     * Driver for RoomReservation
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String menuChoice = "";
        String firstName, lastName;
        double amountPaid;
        int roomNumber;
        Room newRoom;


        ArrayList<Room> hotelListomania = new ArrayList<Room>(); // Construct a new ArrayList of type Room; name it
        // hotelListomania

        addRooms(hotelListomania, NUMROOMS); // Add rooms to hotelListomania
        makeRoomsEmpty(hotelListomania); // Initialize all rooms to be empty

        while (!menuChoice.equals("Q")) {

            System.out.println();
            System.out.print("L: List Reservations, R: Reserve Room, C: Checkout or Q: Quit > ");
            menuChoice = input.next().toUpperCase();

            if (menuChoice.equals("L")) { // Print rooms
                printRoomListing(hotelListomania);
            } else if (menuChoice.equals("R")) { // Reserve room
                System.out.print("Room number: ");
                while (!input.hasNextInt()) {
                    input.next();
                    System.out.print("Enter room number by index: ");
                }
                roomNumber = input.nextInt();
                /**
                 * @try
                 * this is our try exception that will catch user input
                 * and prompt them of their error
                 */
                try {
                    hotelListomania.get(roomNumber).printReservation();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("This index is out of bounds \n" +
                            "Please enter a valid number");
                    continue;
                }
                if (!hotelListomania.get(roomNumber).isEmpty()) {
                    System.out.println("Room " + roomNumber + " is already booked");
                }
                while (hotelListomania.get(roomNumber).isEmpty()) {

                    System.out.print("First name: ");
                    firstName = input.next();
                    System.out.print("Last name: ");
                    lastName = input.next();
                    System.out.print("Amount paid: ");
                    while (!input.hasNextDouble()) {
                        input.next();
                        System.out.println("Enter a price");
                    }
                    amountPaid = input.nextDouble();

                    newRoom = new Room(); // Create new Room object
                    newRoom.reserveRoom(firstName, lastName, amountPaid); // Set fields
                    hotelListomania.set(roomNumber, newRoom); // Add new object to ArrayList

                    System.out.println("Reservation Complete");
                }
            }
            /**
             * This is our other user input to checkout of their
             * room. Takes in  user input to see if they want to check-out
             * giving them an option to terminate their decision.
             */
            if (menuChoice.equals("C")) {
                System.out.print("What room are you checking out of? ");
                while (!input.hasNextInt()) {
                    input.next();
                    System.out.print("Enter room number by index: ");
                }
                roomNumber = input.nextInt();
                if (hotelListomania.get(roomNumber).isEmpty()) {
                    System.out.println("This room is already available");
                } else if (!hotelListomania.get(roomNumber).isEmpty()) {
                    System.out.print("Are you sure? C to contiue: ");
                    String newChoice = "";
                    newChoice = input.next().toUpperCase();
                    if (newChoice.equals("C")) {
                        hotelListomania.get(roomNumber).clearRoom();
                        System.out.println("Room " + roomNumber + " is now available");
                    }
                }
            }
        }
        if (menuChoice.equals("Q")) { // Quit
            System.out.println("<end>");
        } else {
            System.out.println("Choose P, R, Q or C");
        }
    }
}
