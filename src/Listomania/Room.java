package Listomania;

public class Room {

    //Fields
    private String firstName;
    private String lastName;
    private double amountPaid;

    // Constructor
    public Room(){};

    // Methods
    /**
     * Initializes the Room fields with the guest's name and amount of payment
     *
     * @param resFirstName		First Name of the guest
     * @param resLastName		Last Name of the guest
     * @param resAmountPaid		Amount of payment for reservation
     */
    public void reserveRoom(String resFirstName, String resLastName, double resAmountPaid) {
        firstName = resFirstName;
        lastName = resLastName;
        amountPaid = resAmountPaid;
    }

    /**
     * Make a Room empty by setting first and last name to "empty", and amountPaid to 0
     */
    public void clearRoom() {
        firstName = "empty";
        lastName = "empty";
        amountPaid = 0;
    }

    /**
     * Check to see if a Room is empty
     * @return	true if the Room is empty
     */
    public boolean isEmpty() {
        if(firstName.equals("empty") &&  lastName.equals("empty")) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * Print Room fields
     */
    public void printReservation() {
        System.out.println(this.getFirstName() + " " + this.getLastName() + "\t\t Paid: " + this.getAmountPaid());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
}

