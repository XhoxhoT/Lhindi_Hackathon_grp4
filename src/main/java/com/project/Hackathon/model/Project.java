package com.project.Hackathon.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int projectId;

    @Column(name = "ProjectName")
    private String projectName;

    @Column(name = "Description")
    private String description;

}
