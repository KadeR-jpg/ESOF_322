package Lab10;

import java.nio.charset.IllegalCharsetNameException;

/**
 * Lab 10
 * Program Correctness
 *
 * Finish setting up the preconditions and postconditions for the
 * yearsDaysToDays unit test. We want to guarantee the user input is
 * valid, and test output against several vectors to ensure correctness.
 *
 * This program should take two command line argument, both integers between
 * 0 and 1000. The first arg is a number of years, and the second is a number
 * of days. The program is to return the whole amount of time as a number of days.
 *
 * This Unit test uses assert, which can be tested at the command line by typing
 * the command line option -ea Ex: java -ea yd2dUnitTest [arg1, arg2]
 * you may need to be in the bin directory to run it. Ex: java -ea lab10/yd2dUnitTest [arg1, arg2]
 * It is also possible to use command line options and arguments inside the IDE.
 * In Eclipse: Run > Run Configurations... Arguments Tab,
 * Example: Program Arguments (2, 20), VM Arguments (-ea)
 *
 *
 */

public class yd2d {
    public static void ensurePositive(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("It's not a positive int.");
        }
    }

    public static double yearsDaysToDays(int givenYears, int givenDays) {

        double totalDays;

        totalDays = (givenYears * 365) + givenDays;
        double leaps = (totalDays/365) / 4;
        return totalDays + Math.floor(leaps);
    }

    public static void ensureRange(int n, int max) throws IllegalArgumentException {
        if ((n < 0) || (n > max)) {
            throw new IllegalArgumentException("Out of Range.");
        }
    }

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("ERROR: Please restart and provide two command line arguments:");
            System.out.println("A positive integer for years, and a positive integer for number of days.");
            return;
        }
        /**
         *A for:each loop test that both integers pass our exceptions.
         */
        int n = 0;
        for (String arg : args) {
            try {
                n = Integer.parseInt(arg); // attempt the thing that may not work
                ensurePositive(n); // test your condition and throw an exception
            } catch (NumberFormatException e) { // catch the exception that might happen,
                n = 1; // ...and handle it
                System.out.println(arg + " is not an integer. Using 1.");
            } catch (IllegalArgumentException e) {
                n = Math.abs(n); // ...and handle it
                System.out.println(arg + " won't work. Making it positive. " + e.getMessage());
            }
            try {
                n = Integer.parseInt(arg);
                ensureRange(n, 1000);
            }catch (IllegalArgumentException e){
                n = 500;
                System.out.println("That number is too large, set to 500");
            }
        }


        int years = Integer.parseInt(args[0]);
        int days = Integer.parseInt(args[1]);

        double allTheDays = yearsDaysToDays(years, days);
        System.out.println(allTheDays);

        System.out.println("START Unit Test");
        /**
         * assertion test Block.
         */
        assert (yearsDaysToDays(0, 0) == 0) 	: "Assertion 1 failed";
        assert (yearsDaysToDays(0, 1) == 1) 	: "Assertion 2 failed";
        assert (yearsDaysToDays(1, 0) == 365) 	: "Assertion 3 failed";
        assert (yearsDaysToDays(1, 365) == 730) :"Assertion 4 failed";
        assert (yearsDaysToDays(365, 1) == 133317) 	: "Assertion 5 failed";
        assert (yearsDaysToDays(0, 1) == 1) 	: "Assertion 6 failed";
        assert (yearsDaysToDays(2, 2) == 732) 	: "Assertion 7 failed";
        assert (yearsDaysToDays(123, 456) == 45382) :"Assertion 8 failed";
        assert (yearsDaysToDays(0, 365) == 365) :"Assertion 9 failed";
        assert (yearsDaysToDays(1000, 1000) == 366250) : "Assertion 10 failed";

        System.out.println("STOP Unit Test");
    }
}
