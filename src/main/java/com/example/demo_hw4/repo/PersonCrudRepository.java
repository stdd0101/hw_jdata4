package com.example.demo_hw4.repo;

import com.example.demo_hw4.domain.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonCrudRepository extends CrudRepository<Person, Long>{

    Optional<Person> findByCityOfLiving(String city);

    @Query("SELECT t FROM Person t where t.age < :age")
    Optional<Person> findPersonIsLessThanAge(@Param("age") Integer age, Sort sort);

    Optional<Person> findByNameAndSurname(String name, String surname);
}
