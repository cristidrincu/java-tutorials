/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cristiandrincu.jva.collections.maps;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cristiandrincu
 */
public class ComputeIfAbsent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // If you want to add a new entry automatically to a map if it is not present 
        // you can use the computeIfAbsent method to calculate a value and add it to the map.
        
        Map<String, Integer> map = createMap();
        
        Integer calculatedValue = map.computeIfAbsent("Java", newElementValue -> 1);
        System.out.println(calculatedValue); //1
        
        // write to command line
        map.keySet().forEach(key -> System.out.println(key + " " + map.get(key))); // Java 8
    }

    private static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Eclipse IDE", 0);
        map.put("Eclipse RCP", 0);
        map.put("Git", 0);
        map.put("Groovy", 0);
        
        return map;
    }
    
}
