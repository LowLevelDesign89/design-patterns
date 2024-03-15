package com.app.empmgmt.repositories;

import com.app.empmgmt.model.Employee;

public interface EmployeeRepository {
    Employee create(Employee employee);
    Employee update(Employee employee);
    Employee delete(Employee employee);
    Employee get(Long id);
}
