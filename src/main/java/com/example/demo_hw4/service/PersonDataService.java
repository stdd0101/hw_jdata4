package com.example.demo_hw4.service;

import com.example.demo_hw4.domain.Person;
import com.example.demo_hw4.repo.PersonCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PersonDataService {

    @Autowired
    private PersonCrudRepository personCrudRepository;

    @Transactional
    public Optional<Person> findPersonIsLessThanAge(Integer age, Sort sort) {
        Optional<Person> persons = personCrudRepository.findPersonIsLessThanAge(age, Sort.by("age"));
        return persons;
    }

    @Transactional
    public Optional<Person> findByCityOfLiving(String city) {
        Optional<Person> persons = personCrudRepository.findByCityOfLiving(city);
        return persons;
    }

    @Transactional
    public Optional<Person> findByNameAndSurname(String name, String surname) {
        Optional<Person> persons = personCrudRepository.findByNameAndSurname(name, surname);
        return persons;
    }

}
