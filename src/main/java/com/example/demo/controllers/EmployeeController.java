package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll () {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById (@PathVariable long id) {
        return employeeService.getById(id);
    }

    @GetMapping("/{name}")
    public List<Employee> getByName (@PathVariable String name) {
        return employeeService.getByName(name);
    }

    @PostMapping()
    public Employee create (@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping("/{id}")
    public Employee update (
            @PathVariable Integer id,
            @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public Employee delete (@PathVariable Integer id) {
        return employeeService.delete(id);
    }
}
