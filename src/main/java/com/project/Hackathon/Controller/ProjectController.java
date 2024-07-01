package com.project.Hackathon.Controller;

import com.project.Hackathon.exception.ProjectNotFoundException;
import com.project.Hackathon.model.Project;
import com.project.Hackathon.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    // dependency injection
    @Autowired
    private ProjectService projectService;

    // Get all project
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    // Retrieve Project by id

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable int id) {
        return projectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Creating new Project
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    // Update an existing project
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody Project projectDetails) {
        return projectService.getProjectById(id)
                .map(project -> {
                    Project updatedProject = projectService.updateProject(id, projectDetails);
                    return ResponseEntity.ok(updatedProject);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a project based on his id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {

        if(projectService.getProjectById(id).isPresent()){
            projectService.deleteProject(id);
            return ResponseEntity.<Void>noContent().build();
        }else{
            throw new ProjectNotFoundException("Project not found with id: " + id);

        }

    }
}
