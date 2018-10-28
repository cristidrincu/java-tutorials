package basicinputoutputjavautil;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author cristiandrincu
 */
public class Exceptions_Part_2 {

    /**
     * @param args the command line arguments
     */
    
    //catching multiple exceptions in one catch method - implemented since java 7
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down");
        }        
    }       
    private static int divide() {
        int x, y;        
        x = getInt();
        y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;        
    }
    
    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        while(true) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                s.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9");
            }
        }        
    }
    
}
