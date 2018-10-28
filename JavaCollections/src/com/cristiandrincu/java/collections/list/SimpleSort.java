/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cristiandrincu.java.collections.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author cristiandrincu
 */
public class SimpleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a new ArrayList with the Arrays.asList helper method
        List<Integer> list = Arrays.asList(5, 4, 3, 7, 2, 1);
        //sort it
        // Integer implements the Comparable interface. This interface defines the method compare which performs pairwise comparison of the elements and 
        //returns -1 if the element is smaller than the compared element, 0 if it is equal and 1 if it is larger.
        Collections.sort(list);
        //print each element to the console
        list.forEach(System.out::println);
    }
    
}
