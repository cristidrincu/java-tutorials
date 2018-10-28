package javastreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author cristiandrincu
 */
public class StreamsJavaMasterCourse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "071"
        );
        
        List<String> sortedBingoNumbers = someBingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(number -> number.startsWith("G"))                
                .sorted()
                .collect(Collectors.toList());                
        
        sortedBingoNumbers.forEach(System.out::println);
        
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "071");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "071");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("------------------------------------");
        System.out.println(concatStream
                .distinct() //no duplicates in concat stream - distinct() elements - read more on final operations vs intermediate operations in streams
                .peek(System.out::println)
                .count()); 
    }
    
}
