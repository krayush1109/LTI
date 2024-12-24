package com.wecp;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Ayush", 2400.5);
        Employee e2 = new Employee(2, "Sahil", 300.5);

        EmployeeService srv = new EmployeeService();
        srv.addEmployee(e1);
        srv.addEmployee(e2);
        
    }
}
