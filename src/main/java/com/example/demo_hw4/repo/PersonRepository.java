package com.example.demo_hw4.repo;

import com.example.demo_hw4.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> getPersonsByCityOfLiving(String cityOfLiving);
}
