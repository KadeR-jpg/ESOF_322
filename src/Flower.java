/**
 * Kade Pitsch
 * Flower Class
 * Sept, 23 2018
 */
public class Flower {
    //Setting our Variables
    private String name;
    private int numberOfPetals;
    private double price;

    //Constructing Variables
    public Flower(String name, int numberOfPetals, double price){
        this.name = name;
        this.numberOfPetals = numberOfPetals;
        this.price = price;
    }
    //Accessor method, returns our I/O
    public String getName(){
        return name;
    }
    public int getNumberOfPetals(){
        return numberOfPetals;
    }
    public double getPrice(){
        return price;
    }
}
