package com.app.empmgmt;

import com.app.empmgmt.model.Employee;
import com.app.empmgmt.repositories.EmployeeDAOProxy;

public class ProxyDesignPatternTest {
    public static void main(String[] args) {
        EmployeeDAOProxy employeeDAOProxy = new EmployeeDAOProxy();
        Employee employee = new Employee();
        employee.setName("abc");
        employee.setEmail("abc@gmail.com");
        employee = employeeDAOProxy.create("ADMIN", employee);

        System.out.println("Created employee - > " + employee.getId());
    }
}
