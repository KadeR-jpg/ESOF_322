/*

*/
/**
 * Generates a simple progrssion.
 * By default: 0, 1, 2 ...
 *//*

*/
/**public class Progression {
    //Instance variable
    protected long current;

    /**
     * Constructs a progression staring at zero
     *//*

    public Progression(){
        this(0);
    }
    */
/**
     * Constructs a progression with given start value
     * @param start
     *//*

    public Progression(long start){
        current = start;
    }

    */
/**
     * Returns the next value of th e progression
     * @return
     *//*

    public long nextValue(){
        long answer = current;
        advance(); //this protected call is responsible for advancing the current value
        return answer;
    }

    */
/**
     * Advances the current value to the next value of the progression
     *//*

    protected void advance(){
        current ++;
    }

    */
/**
     * Prints the next n values of the progression, seperatedd by spaces.
     * @param n
     *//*

    public void printProgresssion(int n){
        System.out.print(nextValue(int n));
        for(int j = 1; j < n; j++)
            System.out.print(" " = nextValue());
        System.out.println();
    }
}

*/

