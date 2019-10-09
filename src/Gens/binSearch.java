package Gens;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Lab 08
 *
 * Modify the given recursive binary search algorithm so that it returns the index of the target
 * in the sequence or -1 (if the target is not found).
 *
 * Create a static instance variable called searches to track the number of times binarySearch is called
 *
 * In the main method, prompt the user for an array size n, and fill an array with random values between 1 and n.
 * you may use java.util methods Arrays.sort and Arrays.toString to sort and print the array
 *
 * Use your modified search to test the number of searches required to find the target.
 *
 * Try the same test with different input sizes for n.
 * What is the running time of binarySearch?
 * Give your answer in a print statement at the end of the program in big-O notation.
 *
 *
 */

public class binSearch {

    public static int Counter = 0;

    /**
     * Returns true if the target value is found in the indicated portion of the data array.
     * This search only considers the array portion from data[low] to data[high] inclusive.
     */
    public static int binarySearch(int[] data, int target, int low, int high) {
        Counter++;
        if (low > high)
            return -1;                                           // interval empty; no match
        else {
            int mid = (low + high) / 2;
            if (target == data[mid])
                return high;                                          // found a match
            else if (target < data[mid])
                return binarySearch(data, target, low, mid - 1);      // recur left of the middle
            else
                return binarySearch(data, target, mid + 1, high);     // recur right of the middle
        }
    }

    public static int searches(){
        return Counter;
    }

    /** You may use the method main here to test and demo the lab... */
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of Array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(n);
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.print("Enter target integer: ");
        int targ = input.nextInt();
        int high = n-1;

        System.out.println("Target " + targ + " found at index " + binarySearch(arr, targ, 0, high));
        System.out.println(searches() + " searches required for input size " + n + "\n" +
                "Running time is O(log(n)) ");






    }

}