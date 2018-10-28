/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamsintrotutorial;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author cristiandrincu
 */
public class StreamsCollectMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map<String, String> resultMap = new HashMap<>();
        // The reduction can also be provided by the collect() method of type Stream. 
        // This operation is very handy in case of converting a stream to a Collection or a Map and representing a stream in form of a single string.
        List<String> initialList = Arrays.asList("abracadabra", "mumu", "batman", "xyz");
        List<String> transformedList = initialList.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
        
        Iterator<String> iterator1 = initialList.iterator();
        Iterator<String> iterator2 = transformedList.iterator();
        
        while (iterator1.hasNext() && iterator2.hasNext()) {
            resultMap.put(iterator1.next(), iterator2.next());
        }
        
        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ", " + value);
        }
        
        for (String key : resultMap.keySet()) {
            String value = resultMap.get(key);
            System.out.println(key + value);
        }
    }
    
}
