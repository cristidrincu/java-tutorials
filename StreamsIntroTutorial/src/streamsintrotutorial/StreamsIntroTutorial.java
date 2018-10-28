/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamsintrotutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author cristiandrincu
 */
public class StreamsIntroTutorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // java.util.stream - contains classes for processing sequences of elements  
        //stream creation
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);

        // a stream() default method is added to the collection interface and allows creating a Stream<T>
        // using any collection as an element source
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7);
        Stream<Integer> stream2 = list.stream();
        
        List<String> stringList = Arrays.asList("abracadabra", "mumu", "batman", "xyz");

//        Multithreading with streams
//        Stream API also simplifies multithreading by providing the parallelStream() method that runs operations over stream’s elements in parallel mode.
//        The code below allows to run method doWork() in parallel for every element of the stream
        list.parallelStream().forEach(element -> doWork(element));

//          Get distinct elements in the list and tell us how many they are
        long count = list.stream().distinct().count();
        System.out.println(count);

//        Iterating - Stream API helps to substitute for, for-each and while loops. It allows concentrating on operation's logic, but not on the iteration
//        over the sequence of elements
         List<String> results = classicIteration(stringList);
         System.out.println(results);
         
         Stream<String> streamResults = streamIteration(stringList);
         streamResults.forEach(System.out::println);
        
    }

    private static void doWork(Integer integerElement) {
        System.out.println(integerElement);
    }
    
    private static List<String> classicIteration(List<String> stringList) {
        List<String> values = new ArrayList<>();
        for (String string : stringList) {
            if (string.contains("a")) {
                values.add(string);
            }
        }
        
        return values;
    }
    
    private static Stream<String> streamIteration(List<String> stringList) {
    // filter - similar to javascript filter        
        Stream<String> stream = stringList.stream().filter(element -> element.contains("a"));        
        return stream;
    }    

}
