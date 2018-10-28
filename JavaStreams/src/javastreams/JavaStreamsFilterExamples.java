/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author cristiandrincu
 */
public class JavaStreamsFilterExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> lines = Arrays.asList("spring", "node", "mykong");
        List<String> result = lines.stream() //convert list to stream
                .filter(line -> !"mykong".equals(line)) //we dont like mykong
                .collect(Collectors.toList()); //collect the output and convert streams to a List
        
        result.forEach(System.out::println);
        
        //example for stream methods filter(), findAny() and orElse()
        List<Person> persons = Arrays.asList(
                new Person("mykong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );
        
        Person result1 = persons.stream() //convert to stream
                .filter(person -> "jack".equals(person.getName())) //we want jack only
                .findAny() //if findAny, then return found
                .orElse(null); //If not found, return null
        
        System.out.println(result1); //Person{name=jack, age=20}
        
        Person result2 = persons.stream()
                .filter(person -> "ahmook".equals(person.getName()))
                .findAny()
                .orElse(null);
        
        System.out.println(result2); //null
        
        //using multiple conditions when filtering - we are using the same persons ArrayList
        Person result3 = persons.stream()
                .filter(person -> "jack".equals(person.getName()) && person.getAge() == 20)
                .findAny()
                .orElse(null);
        
        System.out.println("result3 " + result3); ////Person{name=jack, age=20}
        
        //example for stream methods filter() and map()
        String name = persons.stream()
                .filter(person -> "jack".equals(person.getName()))
                .map(Person::getName) //convert stream to string
                .findAny()
                .orElse(null);
        
        System.out.println(name);
        
        List<String> collect = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        
        collect.forEach(System.out::println);
    }
    
}
