package Gens;

import java.util.*;

public class InsertionSorterDemo {
    public static void main(String[] args) {
        //Declared variable and other Instances
        boolean stop = false;
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        System.out.print("How many integers in your array: ");
        int[] arr = new int[input.nextInt()];
        //While loop for continual user input
        while (!stop) {
            System.out.println("1. Sort Ascending\n" +
                    "2. Sort Descending\n" +
                    "3. Shuffle\n" +
                    "4. Quit\n");
            int choice = input.nextInt();
            //An array random population for loop
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rand.nextInt(100);
            }
            //Keeping track of our original array
            int[] orig = Arrays.copyOf(arr, arr.length);
            //Instantiating our class calling it "sort"
            InsertionSorter sort = new InsertionSorter();

            System.out.println("Original array: " + Arrays.toString(orig));
            //Switch statement for user I/O
            switch (choice) {
                case 1:
                    System.out.println("Increasing order Array: " + Arrays.toString(sort.increaseOrder(arr)));
                    break;
                case 2:
                    System.out.println("Decreasing order Array: " + Arrays.toString(sort.decreaseOrder(arr)));
                    break;
                case 3:
                    System.out.println("Shuffledd Array: " + Arrays.toString(sort.shuffle(arr)));
                    break;
                case 4:
                    System.out.println("Increasing order Array: " + Arrays.toString(sort.increaseOrder(arr)));

                    System.out.println("Decreasing order Array: " + Arrays.toString(sort.decreaseOrder(arr)));

                    System.out.println("Shuffled Array: " + Arrays.toString(sort.shuffle(arr)));

                    stop = true;
                    break;
            }
        }
    }
}

