package pl.wydarzenia.person.service.impl;

import org.springframework.stereotype.Service;
import pl.wydarzenia.person.model.Person;
import pl.wydarzenia.person.service.PersonService;
import pl.wydarzenia.utils.test.TestHelper;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private List<Person> persons = TestHelper.getTestPersons();

    @Override
    public List<Person> getAllPersons() {
        return TestHelper.getTestPersons();
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
