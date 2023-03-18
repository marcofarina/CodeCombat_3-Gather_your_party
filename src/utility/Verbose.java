package codeCombat.utility;

public class Verbose {

    public static boolean verbose = true;
    public static void print(String message) {
        if(verbose){
            System.out.println(message);
        }
    }
}
