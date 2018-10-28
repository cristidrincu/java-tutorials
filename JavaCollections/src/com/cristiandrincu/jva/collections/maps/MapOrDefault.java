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
public class MapOrDefault {

// Java 8 introduces the getOrDefault() method, which allows to get the current value and if this is not found in the map to return a default value.
    public static void main(String[] args) {
        Map<String, Integer> map = createMap();
        map.put("Android", 1 + map.getOrDefault("Android", 0));
        
        //write to command line
        map.forEach((key, value) -> System.out.printf("%s %s%n", key, value));
    }

    private static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Eclipse IDE", 0);
        map.put("Eclipse RCP", 0);
        map.put("Git", 0);
        
        return map;
    }
    
}
