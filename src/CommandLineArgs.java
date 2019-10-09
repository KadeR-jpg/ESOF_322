public class CommandLineArgs {
    public static void main(String[] args){
        if (args.length != 2){
            System.out.println("You need a string, followed by an integer");
            return;
        }
    String userString = args[0];
    int n = 0;
    try {
        n = Integer.parseInt(args[1]);
    }catch (NumberFormatException e){
        n = 1;
        System.out.println("You Fucked up, " + args[1] + " is not an integer. \n " +
                "Printing once.");
    }

    for(int i = 0; i < n; i++){
        System.out.println(userString);
    }
    }

}

