package com.project.Hackathon.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import jakarta.validation.constraints.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int projectId;

    @NotBlank(message = "Project name is mandatory")
    @Size(min = 2, max = 100, message = "Project name must be between 2 and 100 characters")
    @Column(name = "ProjectName")
    private String projectName;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    @Column(name = "Description")
    private String description;

    @ManyToMany(mappedBy = "projects")
    private Set<Person> persons = new HashSet<>();

    public Project(int projectId, String projectName, String description) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.description = description;
        this.persons=new HashSet<>();
    }

    public Project(){

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
