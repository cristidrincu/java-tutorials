/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cristiandrincu.jva.collections.maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cristiandrincu
 */
public class ConvertMapTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // keys are Strings
        // objects are also Strings
        Map<String, String> map = new HashMap<>();
        fillData(map);
        
        //convert keys to array
        String[] strings = keysAsArray(map);
        for (String string : strings) {
            System.out.println(string);
        }
        
        //convert keys to list
        List<String> list = keysAsList(map);
        list.forEach((element) -> System.out.println(element));       
    }

    private static void fillData(Map<String, String> map) {
        map.put("Android", "Mobile");
        map.put("Eclipse IDE", "Java");
        map.put("Eclipse RCP", "Java");
        map.put("Git", "Version control system");
    }

    private static String[] keysAsArray(Map<String, String> map) {
        return map.keySet().toArray(new String[map.keySet().size()]);
    }

    // assumes the key is of type String
    private static List<String> keysAsList(Map<String, String> map) {
        List<String> list = new ArrayList<>(map.keySet());
        return list;
    }
    
}
