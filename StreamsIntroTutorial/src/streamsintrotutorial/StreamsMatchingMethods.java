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
public class StreamsMatchingMethods {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<String> stringList = Arrays.asList("abracadabra", "mumu", "batman", "xyz");
        
        //trying out anyMatch, allMatch and noneMatch methods from stream API
         System.out.println(allElementsMatchCriteria(stringList, "a"));
         System.out.println(someElementsMatchCriteria(stringList, "a"));
         System.out.println(noElementsMatchCriteria(stringList, "j"));
    }
    
    private static boolean allElementsMatchCriteria(List<String> stringList, String criteria) {
        return stringList.stream().allMatch(element -> element.contains(criteria));
    }
    
    private static boolean someElementsMatchCriteria(List<String> stringList, String criteria) {
        return stringList.stream().anyMatch(element -> element.contains(criteria));
    }
    
    private static boolean noElementsMatchCriteria(List<String> stringList, String criteria) {
        return stringList.stream().noneMatch(element -> element.contains(criteria));
    }
    
}
