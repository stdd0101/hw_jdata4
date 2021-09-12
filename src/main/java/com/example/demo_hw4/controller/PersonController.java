package com.example.demo_hw4.controller;

import com.example.demo_hw4.domain.Person;
import com.example.demo_hw4.service.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonDataService personDataService;

    @GetMapping("/by-city")
    public @ResponseBody
    Optional<Person> byCityOfLiving(@RequestParam String city) {
        return personDataService.findByCityOfLiving(city);
    }

    @GetMapping("/by-age")
    public @ResponseBody
    Optional<Person> byAge(@RequestParam Integer age) {
        return personDataService.findPersonIsLessThanAge(age, Sort.by("age"));
    }

    @GetMapping("/by-name")
    public @ResponseBody
    Optional<Person> byNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personDataService.findByNameAndSurname(name, surname);
    }
}
