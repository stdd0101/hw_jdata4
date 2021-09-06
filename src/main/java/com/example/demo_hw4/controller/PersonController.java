package com.example.demo_hw4.controller;

import com.example.demo_hw4.domain.Person;
import com.example.demo_hw4.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/by-city")
    public @ResponseBody
    Iterable<Person> byCity(@RequestParam String city) {
        // This returns a JSON or XML with the persons
        return personRepository.getPersonsByCityOfLiving(city);
    }
}
