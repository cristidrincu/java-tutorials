/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamsflatmap;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristiandrincu
 */
public class Department {

    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    
    public List<Employee> getEmployees() {
        return employees;
    }
}
