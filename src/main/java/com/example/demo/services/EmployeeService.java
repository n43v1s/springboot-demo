package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll () {
        return employeeRepository.findAll();
    }

    public Employee getById (long id) {
        return employeeRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"
                )
            );
    }

    public List<Employee> getByName (String name) {
        return employeeRepository.getByName(name);
    }

    public Boolean existByEmail (String email) {
        return employeeRepository.existsByEmail(email);
    }

    public Employee create (Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update (long id, Employee employee) {
        getById(id);
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public Employee delete (long id) {
        Employee employee = getById(id);
        employeeRepository.delete(employee);
        return employee;
    }
}
