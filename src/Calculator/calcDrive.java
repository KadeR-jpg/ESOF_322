package Calculator;

import java.util.*;

import static Calculator.Calculate.*;

/**
 * Our Calculator Driver, accepts user input and sends it to
 * our main calculator class.
 */

public class calcDrive {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double inV, inV1; //number;
        boolean stop = false;

        while (!stop) {
            try {
                double number = 0;
                String prompt = "Total is now: ";
                String enter = "Enter a number: ";

                System.out.print("Enter Number: ");
                inV = input.nextDouble();

                System.out.print("+, -, *, ^, or = : ");
                char oper = input.next().charAt(0);

                if (oper == '=') stop = true;
/**
 * The switch statement to decide what method to access from the Calculate class
 */
                switch (oper) {
                    case '+':
                        System.out.print(enter);
                        inV1 = input.nextDouble();
                        number = add(inV, inV1);
                        System.out.println(prompt + number);
                        break;
                    case '-':
                        System.out.println(enter);
                        inV1 = input.nextDouble();
                        number = sub(inV, inV1);
                        System.out.println(prompt + number);
                        break;
                    case '/':
                        System.out.print(enter);
                        inV1 = input.nextDouble();
                        number = divide(inV, inV1);
                        System.out.println(prompt + number);
                        break;
                    case '%':
                        System.out.print(enter);
                        inV1 = input.nextDouble();
                        number = modulo(inV, inV1);
                        System.out.println(prompt + number);
                        break;
                    case '^':
                        System.out.print(enter);
                        inV1 = input.nextDouble();
                        number = power(inV, inV1);
                        System.out.println(prompt + number);
                        break;
                    case '=':
                        System.out.print(prompt + number);
                        System.exit(0);
                    default:
                        System.out.print(prompt + number);
                }
                /**
                 * Our catch finally block that will catch wrong user input and then delete the
                 * left over token on the next line so we can loop back around
                 */
            } catch (InputMismatchException e) {
                System.out.println("That is the wrong data-type");
            } finally {
                input.nextLine();
            }
        }
    }
}



