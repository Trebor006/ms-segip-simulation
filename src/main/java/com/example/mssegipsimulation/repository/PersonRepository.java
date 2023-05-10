package com.example.mssegipsimulation.repository;

import com.example.mssegipsimulation.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

  @PersistenceContext private EntityManager entityManager;

  public Optional<Person> findOneByIdentificacion(String identificacion) {
    return entityManager
        .createQuery(
            " SELECT p  " + " FROM Person p " + " WHERE p.identification = :identification",
            Person.class)
        .setParameter("identification", identificacion)
        .getResultList()
        .stream()
        .findFirst();
  }

  public List<Person> findAll() {
    return entityManager
        .createQuery(" SELECT p  " + " FROM Person p ", Person.class)
        .getResultList();
  }

  @Transactional
  public Person save(Person person) {
    entityManager.persist(person);
    return person;
  }
}
