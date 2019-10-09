
import java.util.Scanner;

public class lab2 {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        int [] uVal = new int[5];
        for(int i = 0; i < 5; i++){
            System.out.println("Please enter an integer: ");
            uVal[i] = src.nextInt();
        }
        boolean match = false;
        for (int i = 0; i < uVal.length; i++){
            for (int j = i + 1; j < uVal.length; j++){
                if (uVal[i] == uVal[j]){
                    System.out.printf("Integer %d has a match! ", uVal[i]);
                    match = true;

                }
            }
        }
        if(match == false){
            System.out.println("None of those match");
        }
        src.close();
    }
}
