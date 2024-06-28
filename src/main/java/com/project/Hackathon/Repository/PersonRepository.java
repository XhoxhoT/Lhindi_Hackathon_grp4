package com.project.Hackathon.Repository;

import com.project.Hackathon.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);

    List<Person> findBySkillsContaining(String skill);

    List<Person> findByExperience(String experience);


}
