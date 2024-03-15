package com.app.empmgmt.repositories;

import com.app.empmgmt.model.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class EmployeeDAOImpl implements EmployeeRepository {
    private Map<Long, Employee> employees = new HashMap<>();
    private AtomicLong empId = new AtomicLong(1l);

    @Override
    public Employee create(Employee employee) {
        employee.setId(empId.get());
        empId.incrementAndGet();
        employees.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee storedEmployee = employees.get(employee.getId());
        storedEmployee.setName(employee.getName());
        storedEmployee.setEmail(employee.getEmail());
        employees.put(storedEmployee.getId(), storedEmployee);
        return storedEmployee;
    }

    @Override
    public Employee delete(Employee employee) {
        Employee storedEmployee = employees.get(employee.getId());
        employees.remove(employee.getId());
        return storedEmployee;
    }

    @Override
    public Employee get(Long id) {
        return employees.getOrDefault(id, null);
    }
}
