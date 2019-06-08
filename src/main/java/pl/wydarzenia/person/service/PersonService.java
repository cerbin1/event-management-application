package pl.wydarzenia.person.service;

import pl.wydarzenia.person.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();

    Person getPersonById(long personId);
}
