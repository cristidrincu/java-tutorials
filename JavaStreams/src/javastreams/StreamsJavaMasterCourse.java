package javastreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import streamsflatmap.Department;
import streamsflatmap.Employee;

/**
 *
 * @author cristiandrincu
 */
public class StreamsJavaMasterCourse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "071"
        );
        
        List<String> sortedBingoNumbers = someBingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(number -> number.startsWith("G"))                
                .sorted()
                .collect(Collectors.toList());                
        
        sortedBingoNumbers.forEach(System.out::println);
        
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "071");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "071");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("------------------------------------");
        System.out.println(concatStream
                .distinct() //no duplicates in concat stream - distinct() elements - read more on final operations vs intermediate operations in streams
                .peek(System.out::println)
                .count()); 
        
        
            //flat map
        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee christian = new Employee("Cristian Drincu", 30);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        Department marketing = new Department("Marketing");
        
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(christian);
        hr.addEmployee(snow);
        marketing.addEmployee(john);
        
        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(marketing);
        
        //stream operations like filter, map etc are lazily evaluated, they are called intermediate operations
        //- this means that they will not be executed until a terminal operation is appended to the pipe -
        //a terminal operation is collect, reduce.
        //flat nested lists contained in an object - in our case, the object containing the lists is department which has a list of employees
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);
        
        //grouping by criteria
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));
        
        System.out.println("Grouped by age: " + groupedByAge.toString());
        
        //using the reduce terminal operation
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);
        
    }
}
