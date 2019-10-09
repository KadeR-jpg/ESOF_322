package Gens;

import java.util.*;

import static java.util.Arrays.*;

public class InsertionSorter {

    //our increase order method
    public int[] increaseOrder(int[] sortedArr) {
        int len = sortedArr.length;
        for (int k = 1; k < len; k++) {
            int current = sortedArr[k];
            int j = k;
            while (j > 0 && sortedArr[j - 1] > current) {
                sortedArr[j] = sortedArr[j - 1];
                j--;
            }
            sortedArr[j] = current;
        }
        return sortedArr;
    }

    //Our decrease order that is exactly the same as or increase except for one conditional statement.
    //"sortedArr[j-1]<current"
    public int[] decreaseOrder(int[] sortedArr) {
        int len = sortedArr.length;
        for (int k = 1; k < len; k++) {
            int current = sortedArr[k];
            int j = k;
            while (j > 0 && sortedArr[j - 1] < current) {
                sortedArr[j] = sortedArr[j - 1];
                j--;
            }
            sortedArr[j] = current;
        }
        return sortedArr;
    }

    //Our shuffle method that takes a random number in the index of our original array and switches them for every loop
    //until we are 1 less than the original length of the array.
    public int[] shuffle(int[] arr) {
        int len = arr.length;
        Random rand = new Random();
        for (int i = len - 1; i > 0; i--) {
            int j = rand.nextInt(i);
            int temporary = arr[i];
            arr[i] = arr[j];
            arr[j] = temporary;
        }
        return arr;
    }


}



