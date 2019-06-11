package pl.wydarzenia.person.dao;

import pl.wydarzenia.person.model.Person;

import java.util.List;

public interface PersonDao {
    List<Person> getAllPersons();

    Person getById(long personId);

    int update(Person person);

    boolean delete(long personId);
}
