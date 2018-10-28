package com.cristiandrincu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {		
		new Thread(() -> {
			System.out.println("Printing from the Runnable");
			System.out.println("Line 2");
		}).start();
		
		Employee john = new Employee("John", 36);
		Employee tim = new Employee("Tim", 21);
		Employee jack = new Employee("Jack", 21);
		Employee snow = new Employee("Snow White", 21);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.addAll(Arrays.asList(john, tim, jack, snow));
		
//		Collections.sort(employees, new Comparator<Employee>(){
//			@Override
//			public int compare(Employee employee1, Employee employee2) {					
//				return employee1.getName().compareTo(employee2.getName());
//			}			
//		});
		
		//if it's just one line (statement), like in the case of employee1.getName().compareTo(employee2.getName()), we do not need -> { //code here } and it will not work if only one line and we use -> { //code here }
		//if multiple lines (the lambda has a body), then -> { //code here } are mandatory and the return keyword is required
		//types can be omitted from lambdas. The compiler infers the types based on the first parameter, which is a list of Employees
		Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));
		
//		for(Employee employee : employees) {
//			System.out.println(employee.getName());
//			new Thread(() -> System.out.println(employee.getAge())).start();
//		}
		
		//lambda foreach
		employees.forEach(employee -> {
			System.out.println(employee.getName());
			System.out.println(employee.getAge());
		});
		
//		Without lambda expression
//		String sillyString = doStringStuff(new UpperConcat() {
//			@Override
//			public String upperAndConcat(String s1, String s2) {				
//				return s1.toUpperCase() + s2.toUpperCase();
//			}			
//		}, employees.get(0).getName(), employees.get(1).getName());
//		
//		System.out.println(sillyString);
		
		//Lambdas only work on interfaces with just one method, like UpperConcat, which only has the upperAndConcat method
		//Parameter types are inferred by the compiler		
		UpperConcat uc = (s1, s2) -> {
			String result = s1.toUpperCase() + s2.toUpperCase();
			return result;
		};
		String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
		System.out.println(sillyString);
		
		AnotherClass anotherClass = new AnotherClass();
		String s = anotherClass.doSomething();
		System.out.println(s);
	}
	
	public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
		return uc.upperAndConcat(s1, s2);
	}	
}

class Employee {
	private String name;
	private int age;
	
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}	
}

interface UpperConcat {
	public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
	public String doSomething() {				
		UpperConcat uc = (s1, s2) -> {
			System.out.println("The lambda expression's class name is " + getClass().getSimpleName());			
			String result = s1.toUpperCase() + s2.toUpperCase();
			return result;
		};
						
		System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
		return Main.doStringStuff(uc, "String1", "String2");
		}		
}
