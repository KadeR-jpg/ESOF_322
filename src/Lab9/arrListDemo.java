package Lab9;

import java.lang.reflect.Array;
import java.util.Arrays;

public class arrListDemo {
    public static void main(String[] args){
        ArrayList<Object> myArr = new ArrayList<>(16);
        myArr.add(0, 2);
        myArr.add(1, 10);
        myArr.add(2, 14);
        myArr.add(3, 36);
        myArr.toString();
        System.out.println(myArr);
        System.out.println("List contains 10 " + myArr.contains(10));
        System.out.println("List contains 11 " + myArr.contains(11));
        myArr.clear();
        myArr.toString();
        System.out.println(myArr);
        ArrayList<String> strArr = new ArrayList<>(16);
        strArr.add(0, "Worst");
        strArr.add(1,"Bad");
        strArr.add(2,"Better");
        strArr.add(3,"Best");
        System.out.println(strArr.toString());
        strArr.add(2, "meh");
        System.out.println(strArr.toString());
        strArr.remove(0);
        strArr.remove(0);
        strArr.set(0, "Good");
        System.out.println(strArr.toString());







    }
}
