
import java.util.*;

 /**
 * Kade Pitsch
 * Dice roller
 * Sept 23, 2018
 */
public class Dice {
    private int rollCount;
    private Random roll;
    private int toss;
    int result = 0;

    /**
     * This is a dice roll constuctor,
     * returning the User input for roll count
     * @param rollCount The user input for how many times they want to roll
     */
    public Dice(int rollCount){
        this.rollCount = rollCount;
        roll = new Random();
    }

    /**
     * Returns our roll count
     * @return
     */
    public int getRollCount() {
        return rollCount;
    }

    public int toss(){
        result = roll.nextInt(5);
        result++;
        return result;

    }

    /**
     * Returns the average dice roll
     * @return
     */
    public double getAverage() {
        double sum = 0;
        double average;
        for (int i = 0; i < rollCount; ++i){
            result = roll.nextInt(5);
            result ++;
            return result;
        }
        return (double) (float)(sum / rollCount);
    }

}

