package pl.wydarzenia.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wydarzenia.person.dao.PersonDao;
import pl.wydarzenia.person.model.Person;
import pl.wydarzenia.person.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    @Override
    public Person getPersonById(long personId) {
        return personDao.getById(personId);
    }

    @Override
    public int updatePerson(Person person) {
        return personDao.update(person);
    }

    @Override
    public boolean deletePersonWithId(long personId) {
        return personDao.delete(personId);
    }
}
