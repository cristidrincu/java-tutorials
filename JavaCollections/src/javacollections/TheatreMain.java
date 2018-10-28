package javacollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author cristiandrincu
 */
public class TheatreMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);
        //shallow copy - new list, but objects the same as the ones in the seats list from theatre (references are pointing to the same objects in memory) - the use of a public class Seat inside the Theatre class is bad practice,
        //but for testing purposes, it works now 
                               
        if(theatre.reserveSeat("A02")) {
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already reserved");
        }
        
        if(theatre.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Seat already reserved");
        }
        
        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);
        
        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);
                               
    }
    
    public static void printList(List<Theatre.Seat> list) {
        list.forEach(seat -> {
            System.out.print(seat.getSeatNumber() + " $" + seat.getPrice());             
        });
        System.out.println();
        System.out.println("===================================================");
    }       
    
}
