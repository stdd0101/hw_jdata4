package com.example.demo_hw4.repo;

import com.example.demo_hw4.domain.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonRepositoryImpl implements PersonRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCityOfLiving(String cityOfLiving) {
        List<Person> persons = entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.cityOfLiving = :cityOfLiving")
                .setParameter("cityOfLiving", cityOfLiving)
                .setMaxResults(10)
                .getResultList();

        return persons;
    }
}