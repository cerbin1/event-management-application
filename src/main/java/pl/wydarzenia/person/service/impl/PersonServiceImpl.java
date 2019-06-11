package pl.wydarzenia.person.service.impl;

import org.springframework.stereotype.Service;
import pl.wydarzenia.person.model.Person;
import pl.wydarzenia.person.service.PersonService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private List<Person> persons = new ArrayList<>();

    @Override
    public List<Person> getAllPersons() {
        return persons;
    }

    @Override
    public Person getPersonById(long personId) {
        return persons
                .stream()
                .filter(person -> person.getId() == personId)
                .findFirst()
                .orElse(null);
    }
}
