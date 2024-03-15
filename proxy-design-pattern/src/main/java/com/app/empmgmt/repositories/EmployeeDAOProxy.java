package com.app.empmgmt.repositories;

import com.app.empmgmt.model.Employee;

public class EmployeeDAOProxy {
    private EmployeeRepository employeeRepository;

    public EmployeeDAOProxy() {
        employeeRepository = new EmployeeDAOImpl();
    }

    public Employee create(String clientId, Employee employee) {
        if(clientId.equals("ADMIN")) {
            return employeeRepository.create(employee);
        }
        throw new RuntimeException("Access Denied");
    }

    public Employee update(String clientId, Employee employee) {
        if(clientId.equals("ADMIN")) {
            return employeeRepository.update(employee);
        }
        throw new RuntimeException("Access Denied");
    }

    public Employee delete(String clientId, Employee employee) {
        if(clientId.equals("ADMIN")) {
            return employeeRepository.delete(employee);
        }
        throw new RuntimeException("Access Denied");
    }

    public Employee get(String clientId, Long id) {
        if(clientId.equals("ADMIN") || clientId.equals("USER")) {
            return employeeRepository.get(id);
        }
        throw new RuntimeException("Access Denied");
    }
}
