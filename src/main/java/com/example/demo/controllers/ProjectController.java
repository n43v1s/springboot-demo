package com.example.demo.controllers;

import com.example.demo.models.Project;
import com.example.demo.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@AllArgsConstructor
public class ProjectController {
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAll () {
        return projectService.getAll();
    }

    @GetMapping("/{id}")
    public Project getById (@PathVariable long id) {
        return projectService.getById(id);
    }

    @PostMapping
    public Project create (@RequestBody Project project) {
        return projectService.create(project);
    }

    @PutMapping("/{id}")
    public Project update (
            @PathVariable long id,
            @RequestBody Project project
    ) {
        return projectService.update(id, project);
    }

    @DeleteMapping("/{id}")
    public Project delete (@PathVariable long id) {
        return projectService.delete(id);
    }
}
