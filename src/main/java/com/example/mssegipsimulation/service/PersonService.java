package com.example.mssegipsimulation.service;

import com.example.mssegipsimulation.dto.PersonDto;
import com.example.mssegipsimulation.entity.Person;
import com.example.mssegipsimulation.repository.PersonRepository;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;

  public PersonDto getPersonByCi(String identification) {

    Optional<Person> personOpt = personRepository.findOneByIdentificacion(identification);
    if (personOpt.isPresent()) {
      //      throw Person
    }
    Person person = personOpt.get();

    return PersonDto.builder()
        .id(person.getId())
        .name(person.getName())
        .lastname(person.getLastname())
        .dateOfBirth(person.getDateofbirth())
        .gender(person.getGender())
        .identification(person.getIdentification())
        .address(person.getAddress())
        .phone(person.getPhone())
        .photo(person.getPhoto())
        .build();
  }

  public List<Person> getPersons() {

    List<Person> persons = personRepository.findAll();

    return persons;
  }

  public PersonDto save(Person person) {
    personRepository.save(person);

    return PersonDto.builder()
        .id(person.getId())
        .name(person.getName())
        .lastname(person.getLastname())
        .dateOfBirth(person.getDateofbirth())
        .gender(person.getGender())
        .identification(person.getIdentification())
        .address(person.getAddress())
        .phone(person.getPhone())
        .build();
  }
}
