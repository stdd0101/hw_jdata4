package com.example.demo_hw4.repo;

import com.example.demo_hw4.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PersonRepository {
    List<Person> getPersonsByCityOfLiving(String cityOfLiving);
}
