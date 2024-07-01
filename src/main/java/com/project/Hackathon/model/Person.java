package com.project.Hackathon.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int personId;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters")
    @Column(name = "surname")
    private String surname;

    @ElementCollection
    private List<String> skills;

    private String experience;
    private String photoUrl;

    public Person() {
    }

    @ManyToMany
    @JoinTable(
            name = "person_project",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects;

    public Person(int personId, String name, String surname, List<String> skills, String experience, String photoUrl) {
        this.personId = personId;
        this.name = name;
        this.surname = surname;
        this.skills = skills;
        this.experience = experience;
        this.photoUrl = photoUrl;
        this.projects = new HashSet<>();
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", skills=" + skills +
                ", experience='" + experience + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
