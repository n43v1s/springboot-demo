package com.example.demo.repositories;

import com.example.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JPQL
    @Query("SELECT E FROM Employee E WHERE E.firstName = ?1 OR E.lastName = ?1")
    public List<Employee> getByName (String name);

    // Native
    // @Query(value = "SELECT * FROM tb_Region WHERE region_name = :name", nativeQuery = true)

    // Query Method
    // public Boolean existsByFirstNameAndAndLastName(String name);
    public Boolean existsByEmail (String email);

}
