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
public class MapTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // keys are Strings
        // objects are also Strings
        Map<String, String> map = new HashMap<>();
        fillData(map);
        
        //write to command line
        map.forEach((key, value) -> System.out.printf("%s %s%n", key, value));
        
        //add and remove from the map - when adding to a map, the key-value pair gets prepended to the map, not appened to the end of the map
        map.put("iPhone", "Created by Apple");
        map.remove("Android");
        
        //write again to command line
        map.forEach((key, value) -> System.out.printf("%s %s%n", key, value));
    }

    private static void fillData(Map<String, String> map) {
        map.put("Android", "Mobile");
        map.put("Eclipse IDE", "Java");
        map.put("Eclipse RCP", "Java");
        map.put("Git", "Version control system");
    }
    
}
