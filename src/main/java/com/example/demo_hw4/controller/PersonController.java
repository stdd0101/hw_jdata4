package com.example.demo_hw4.controller;

import com.example.demo_hw4.domain.Person;
import com.example.demo_hw4.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;


    @GetMapping("/by-city")
    public String byCity(@RequestParam String cityOfLiving, Map<String, Object> model) {
        Iterable<Person> persons;

        if (cityOfLiving != null && !cityOfLiving.isEmpty()) {
            persons = personRepository.getPersonsByCityOfLiving(cityOfLiving);
        } else {
            persons = personRepository.findAll();
        }

        model.put("persons", persons);

        return "main";
    }
}
