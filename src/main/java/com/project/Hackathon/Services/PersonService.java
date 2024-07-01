package com.project.Hackathon.Services;

import com.project.Hackathon.Repository.PersonRepository;
import com.project.Hackathon.Repository.ProjectRepository;
import com.project.Hackathon.exception.*;
import com.project.Hackathon.model.Person;
import com.project.Hackathon.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ProjectRepository projectRepository;


    public Person assignProjectToPerson(int personId, int projectId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + personId));

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with id: " + projectId));

        person.getProjects().add(project);
        return personRepository.save(person);
    }

    public Person removeProjectFromPerson(int personId, int projectId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + personId));

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with id: " + projectId));

        person.getProjects().remove(project);
        return personRepository.save(person);
    }




}
