package com.wecp;

import java.util.*;

public class EmployeeService {
    // complete the implementation here
    Map<Integer, Employee> employeeMap = new HashMap<>();

    public void addEmployee(Employee employee){
        employeeMap.put(employee.getEmployeeId(), employee);                              
    }

    public Employee getEmployeeByID(int employeeID){
        return employeeMap.get(employeeID);
        // return new Employee(employeeID, null, employeeID);
    }

    public List<Employee> getAllEmployeesSortedByName(){        
        List<Employee> employees = new ArrayList<>(employeeMap.values());
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        return employees;
    }

    public Boolean removeEmployee(int employeeID){
        if(employeeMap.containsKey(employeeID)){
            employeeMap.remove(employeeID);
            return true;
        }
        return false;
    }

}
