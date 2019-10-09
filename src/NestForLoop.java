
import java.util.Scanner;

public class NestForLoop {
    public static void main(String[] args){
        //TODO Auto-Generated method stub

        //int[] myInts = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Scanner src = new Scanner(System.in);
        System.out.println("Enter Number: ");
        int size = src.nextInt();
        int [] myInts = new int[size];
        for (int i = 0; i < size; i++){
            myInts[i] = i + 1;
        }


        for(int i = 0; i < myInts.length; i++) {
            for (int j = 0; j < myInts.length; j++) {
                System.out.print(myInts[i] * myInts[j] + "\t" + "|" + "\t" );
            }
            System.out.println();
        }

    }

}
