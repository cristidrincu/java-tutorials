package basicinputoutputjavautil;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author cristiandrincu
 */
public class Exceptions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = getIntEAFP();
        System.out.println("x is " + x);
    }
    
    private static int getInt() {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
    
    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer ");
        String input = s.next();
        for(int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
               isValid = false;
               break;
            }
        }
        
        if (isValid) {
            return Integer.parseInt(input);
        }
        
        return 0;
    }
    
    //less code with try / catch, more elegant that LBYL - look before you leap
    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        try {
            return s.nextInt();
        } catch(InputMismatchException e) {
            return 0;
        }
    }
    
    //Look Before You Leap - programming concept that any operation that might cause an unexpected result should have a guard clause y != 0
    private static int divideLookBeforeYouLeap(int x, int y) {
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }
    
    //Easier to ask for forgiveness than it is to get permission concept - throw an exception an be wrapped in a try catch block
    private static int divideEasierToAskForForgivenessThanPermission(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
    
    //crashes program
    private static int divide(int x, int y) {
        return x / y;
    }
    
}
