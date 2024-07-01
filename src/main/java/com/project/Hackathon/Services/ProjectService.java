package com.project.Hackathon.Services;

import com.project.Hackathon.model.Project;
import com.project.Hackathon.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(int id) {
        return projectRepository.findById(id);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(int id, Project projectDetails) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));

        project.setProjectName(projectDetails.getProjectName());
        project.setDescription(projectDetails.getDescription());

        return projectRepository.save(project);
    }

    public void deleteProject(int id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        projectRepository.delete(project);
    }
}
