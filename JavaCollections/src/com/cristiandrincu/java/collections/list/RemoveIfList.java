/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cristiandrincu.java.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cristiandrincu
 */
public class RemoveIfList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Demonstration of removeIf");
        List<String> list1 = createList();
        //remove all items that contain an x
        list1.removeIf(element -> element.toLowerCase().contains("x"));
        list1.forEach(element -> System.out.println(element));
    }

    private static List<String> createList() {
        List<String> anotherList = new ArrayList<>();
        anotherList.addAll(Arrays.asList("iPhone", "Ubuntu", "Android", "Mac OS X"));
        
        return anotherList;
    }
    
}
