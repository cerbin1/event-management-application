package pl.wydarzenia.person.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.wydarzenia.person.dao.PersonDao;
import pl.wydarzenia.person.model.Person;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    private static final String SELECT_ALL_PERSONS = "SELECT * FROM persons;";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getAllPersons() {
        return jdbcTemplate.query(SELECT_ALL_PERSONS, (resultSet, i) -> {
            Person person = new Person();
            person.setId(resultSet.getLong("id"));
            person.setName(resultSet.getString("name"));
            person.setSurname(resultSet.getString("surname"));
            person.setPhoneNumber(resultSet.getString("phoneNumber"));
            person.setEmail(resultSet.getString("email"));
            return person;
        });
    }
}
