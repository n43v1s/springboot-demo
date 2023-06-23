package com.example.demo.services;

import com.example.demo.models.Project;
import com.example.demo.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {
    private ProjectRepository projectRepository;

    public List<Project> getAll () {
        return projectRepository.findAll();
    }

    public Project getById (long id) {
        return projectRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Project not found"
                )
            );
    }

    public List<Project> getByName (String name) {
        return projectRepository.getByName(name);
    }

    public Project create (Project project) {
        return projectRepository.save(project);
    }

    public Project update (long id, Project project) {
        getById(id);
        project.setId(id);
        return projectRepository.save(project);
    }

    public Project delete (long id) {
        Project project = getById(id);
        projectRepository.delete(project);
        return project;
    }
}
