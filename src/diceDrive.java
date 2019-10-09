import java.util.*;

/**
 *
 */
public class diceDrive {
    /**
     * This is our driver for the Dice class
     * with a string constructor that inits our Dice class
     * @param args
     */
    public static void main (String args[]) {
        Scanner src = new Scanner(System.in);
        System.out.println("Our dice program will let you roll a die a finite amount\n" +
                "of times and return the average\n");
        System.out.println("How many times would youu like to roll the die? \n" +
                ": ");
        int rollCount = (int) src.nextInt();

        Dice browl = new Dice(rollCount);
        System.out.println("Your dice roll is: " + browl.toss());
    }


}
