package Calculator;

/**
 * Our Calculate class that takes 2 doubles as input
 */
public class Calculate {
    private double inV;
    private double inV1;

    /**
     * @param inV our first user input
     * @param inV1 our second user input
     */
    public Calculate(double inV, double inV1){
        this.inV = inV;
        this.inV1 = inV1;
    }

    /**
     *
     * Our constructor methods that return our calculations.
     * @return
     */
    static double add(double inV, double inV1){return (inV + inV1);}
    static double sub(double inV, double inV1){return (inV - inV1);}
    static double multiply(double inV, double inV1){return (inV * inV1);}
    static double divide(double inV, double inV1){return (inV / inV1);}
    static double modulo(double inV, double inV1){return (inV % inV1);}
    static double power(double inV, double inV1){return Math.pow(inV, inV1);}

}
