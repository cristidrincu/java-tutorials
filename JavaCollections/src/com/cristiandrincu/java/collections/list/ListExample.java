/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cristiandrincu.java.collections.list;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cristiandrincu
 */
public class ListExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //use type inference for ArrayList
        List<Integer> list = Arrays.asList(3, 2, 1, 4, 5, 6, 6);
        
        // alternatively, you can declare the list via:
        // List<Integer> list = new ArrayList<>();
        // and use list.add(element); to add elements
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    
}
