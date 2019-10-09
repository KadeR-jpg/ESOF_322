import java.util.*;
public class flowerDriver {
    public static void main(String[] args){
        //Getting user input
        Scanner scan = new Scanner(System.in);
        //Initializing Sting
        System.out.println("Flower type:");
        String name = scan.nextLine();
        //Initializing integer
        System.out.println("Number of petals:");
        int numberOfPetals = (int) scan.nextInt();
        //Initializing  Double
        System.out.println("Price:");
        double price = (double) scan.nextDouble();
        //Creating a new Instance of Flower
        Flower flow = new Flower(name, numberOfPetals, price);
        //Printing the result of our New flower instance
        System.out.println("Name: " + flow.getName()+ "\n" +
                "Petals: " + flow.getNumberOfPetals() + "\n" +
                "Price: " + flow.getPrice() + "\n" +
                "");
    }
}
