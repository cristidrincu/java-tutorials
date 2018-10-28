/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamsintrotutorial;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cristiandrincu
 */
public class StreamsReduceMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(20, 30, 40, 50, 60);
        System.out.println(computeSumOfNumbers(values));
        System.out.println(computeMultiplicationOfNumbers(values));
        
    }
    
    private static Integer computeSumOfNumbers(List<Integer> values) {
        Integer sum = values.stream().reduce(0, (a, b) -> a + b);
        return sum;
    }
    
    private static Integer computeMultiplicationOfNumbers(List<Integer> values) {
        Integer multiplicationResult = values.stream().reduce(1, (a, b) -> a * b);
        return multiplicationResult;
    }
    
}
