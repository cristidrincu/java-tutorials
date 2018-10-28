
package javacollections;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cristiandrincu
 */
public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "A compiled high level, object-orientated language");
        languages.put("Python", "An intepreted , object-oriented, high-level programming language");
        languages.put("Algol", "An algorithmic language");
        languages.put("Basic", "An all purpose programming language");
        languages.put("Lisp", "Therein lies madness");
            
        //the value pointed by the key "Java" gets overwritten - no warnings whatsoever. Keys must be unique in order to maintain data consistency
//        languages.put("Java", "this course is about java"); 

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about java"); //the value pointed by the key "Java" gets overwritten - no warnings whatsoever. Keys must be unique in order to maintain data consistency
            System.out.println(languages.get("Java"));
        }  
        
        System.out.println("==========================================================================================\n");        
        if (languages.remove("Algol", "An algorithmic language")) { //remove Algol only if key is paired with "An algorithmic language"
            System.out.println("Algol removed!");
        } else {
            System.out.println("Algol not removed, key/value pair not found");
        }
        
        languages.replace("Lisp", "Therein lies madness", "a functional programming language"); //replace value of Lisp key with new value only if old value matches "Therein lies madness"
        
        languages.keySet().forEach((String key) -> {
            System.out.println(key + " : " + languages.get(key));
        });               
    }
}
