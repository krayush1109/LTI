package com.wecp;
    
public class Employee implements Comparable<Employee> {
    private int employeeId;
    private String name;
    private double salary;
    
    public Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }
    
    // @Override
    // public String toString() {
    //     return "Employee{" +
    //             "employeeId=" + employeeId +
    //             ", name='" + name + '\'' +
    //             ", salary=" + salary +
    //             '}';
    // }

}