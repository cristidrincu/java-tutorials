/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamsintrotutorial;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author cristiandrincu
 */
public class StreamsMappingMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7);
        
        Stream<Integer> mappedNumbers = multiplyBy2(list);
        mappedNumbers.forEach(System.out::println);
    }
    
    private static Stream<Integer> multiplyBy2(List<Integer> numbers) {
    //To convert elements of a Stream by applying a special function to them and to collect these new elements into a Stream, we can use the map() method
    // Investigate further about flatMap    
        Stream<Integer> mappedNumbers = numbers.stream().map(number -> number * 2);
        return mappedNumbers;
    }
    
}
