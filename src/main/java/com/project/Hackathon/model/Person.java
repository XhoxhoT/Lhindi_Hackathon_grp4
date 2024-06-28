package com.project.Hackathon.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int personId;

    private String name;
    private String surname;

    @ElementCollection
    private List<String> skills;

    private String experience;
    private String photoUrl;

    public Person() {
    }

    public Person(int personId, String name, String surname, List<String> skills, String experience, String photoUrl) {
        this.personId = personId;
        this.name = name;
        this.surname = surname;
        this.skills = skills;
        this.experience = experience;
        this.photoUrl = photoUrl;
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
