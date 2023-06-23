package com.example.demo.repositories;

import com.example.demo.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    // JPQL
    @Query("SELECT P FROM Project P WHERE P.name = ?1")
    public List<Project> getByName (String name);

    // Queary Method
    public Boolean existsByName(String name);
}
