package com.cristiandrincu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {		
		new Thread(() -> {
			System.out.println("Printing from the Runnable");
			System.out.println("Line 2\n");
		}).start();
		
		Employee john = new Employee("John", 36);
		Employee tim = new Employee("Tim", 21);
		Employee jack = new Employee("Jack", 21);
		Employee snow = new Employee("Snow White", 21);
		Employee number1 = new Employee("Number1", 1);
		Employee number2 = new Employee("Number2", 2);
		Employee number3 = new Employee("Number3", 33);
		Employee number4 = new Employee("Number4", 34);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.addAll(Arrays.asList(john, tim, jack, snow, number1, number2, number3, number4));	
		
		printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
		printEmployeesByAge(employees, "\nEmployess under or 30 years of age", employee -> employee.getAge() <= 30);
		
		//non-lambda, anonymous class new Predicate<Employee>() {}
		printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
			@Override
			public boolean test(Employee employee) {
				return employee.getAge() < 25;
			}			
		});
		
		IntPredicate greaterThan15 = integer -> integer > 15;
		IntPredicate lessThanA100 = integer -> integer < 100;		
		
		int a = 20;
		System.out.println(greaterThan15.test(a));
		System.out.println(greaterThan15.test(a + 5));
		
		System.out.println(greaterThan15.and(lessThanA100).test(a)); //true
		System.out.println(greaterThan15.and(lessThanA100).test(15)); //false - both predicates must be true in order for the evaluation to be true
	}
	
	private static void printEmployeesByAge(List<Employee> employees1, String ageText, Predicate<Employee> ageCondition) {
		System.out.println(ageText);
		System.out.println("===================");
		for(Employee employee: employees1) {
			if (ageCondition.test(employee)) {
				System.out.println(employee.getName());
			}
		}			
	}
}
