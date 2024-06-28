package com.project.Hackathon.Controller;

import com.project.Hackathon.Repository.PersonRepository;
import com.project.Hackathon.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") int personId) {
        Optional<Person> person = personRepository.findById(personId);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") int personId, @RequestBody Person personDetails) {
        Optional<Person> person = personRepository.findById(personId);
        if (person.isPresent()) {
            Person updatedPerson = person.get();
            updatedPerson.setName(personDetails.getName());
            updatedPerson.setSurname(personDetails.getSurname());
            updatedPerson.setSkills(personDetails.getSkills());
            updatedPerson.setExperience(personDetails.getExperience());
            updatedPerson.setPhotoUrl(personDetails.getPhotoUrl());
            personRepository.save(updatedPerson);
            return ResponseEntity.ok(updatedPerson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable(value = "id") int personId) {
        Optional<Person> person = personRepository.findById(personId);
        if (person.isPresent()) {
            personRepository.delete(person.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findByName")
    public List<Person> getPersonByName(@RequestParam(value = "name") String name) {
        return personRepository.findByName(name);
    }

    @GetMapping("/findBySkill")
    public List<Person> getPersonBySkill(@RequestParam(value = "skill") String skill) {
        return personRepository.findBySkillsContaining(skill);
    }

    @GetMapping("/findByExperience")
    public List<Person> getPersonByExperience(@RequestParam(value = "experience") String experience) {
        return personRepository.findByExperience(experience);
    }



}
