package Gens;

import java.util.Arrays;

/**
 * Given a method that reverses the ints in an array,
 * make it generic so it reverses elements of any type array
 * Demo with int, String, and Song arrays.
 *
 * @author danieldefrance
 */

// make this generic...
public class ReverseArray {
    private static <T> void reverse(T[] data) {
        int low = 0, high = data.length - 1;
        while (low < high) {            // swap data[low] and data[high]
            T temp = data[low];
            data[low++] = data[high];    // post-increment of low
            data[high--] = temp;        // post-decrement of high
        }
    }


    public static void main(String[] args) {

        // test with an array of strings (done)
        Integer[] myInts = new Integer[10];
        for (int i = 0; i < myInts.length; i++) {
            myInts[i] = (i + 1) * 5;
        }
        System.out.println(Arrays.toString(myInts));
        //
        ReverseArray.reverse(myInts);
        //
        System.out.println(Arrays.toString(myInts));
        System.out.println("");
        //
        String[] myStr = {"one", "two", "three", "four", "five"};
        //
        System.out.println(Arrays.toString(myStr));
        //
        ReverseArray.reverse(myStr);
        //
        System.out.println(Arrays.toString(myStr));
        System.out.println("");
        //
        Song son1 = new Song("Elton John", "Rocket Man");
        Song son2 = new Song("Young Thug", "Digits");
        Song son3 = new Song("Kanye West", "Last Call");
        Song son4 = new Song("Travis Scott", "Drugs you Should Try");
        Song son5 = new Song("Frank Ocean", "Solo");
        Song son6 = new Song("Kendrick Lamar", "The Blacker the Berry");
        Song[] myArr = {son1, son2, son3, son4, son5, son6};
        System.out.println(Arrays.toString(myArr));
        ReverseArray.reverse(myArr);
        System.out.println(Arrays.toString(myArr));
    }
}
