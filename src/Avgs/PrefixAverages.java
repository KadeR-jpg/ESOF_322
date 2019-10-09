package Avgs;
import java.util.*;


public class PrefixAverages {

    public static double[] prefixAverage1 (double[] x) {
        int n = x.length;
        double[] a = new double[n];
        for (int j = 0; j < n; j++) {
            double total = 0;
            for (int i = 0; i <= j; i++)
                total += x[i];
            a[j] = total / (j + 1);

        }
        return a;
    }

    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        double total = 0;
        for (int j = 0; j < n; j++) {
            total += x[j];
            a[j] = total / (j + 1);
        }
        return a;
    }

    public static double[] randArr(int test){
        Random rand = new Random();
        double[] arr = new double[test];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = rand.nextInt(100);
        }
        return arr;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 10;


        for (int i = 0; i < 5; i++) {
            long startTime1 = System.nanoTime();
            prefixAverage1(randArr(n));
            long endTime1 = System.nanoTime();
            long elapse = (endTime1 - startTime1);
            System.out.println("n = " + n + " alg1: " + elapse + "ns");
            long startTime2 = System.nanoTime();
            prefixAverage2(randArr(n));
            long stopTime2 = System.nanoTime();
            long elapse2 = (stopTime2 - startTime2);
            System.out.println("n = " + n + " alg2: " + elapse2 + "ns");
            n *= 10;
        }
        System.out.print("");

    }

}
