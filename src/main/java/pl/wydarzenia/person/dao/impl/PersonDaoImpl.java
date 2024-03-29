package pl.wydarzenia.person.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.wydarzenia.person.dao.PersonDao;
import pl.wydarzenia.person.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    public static final String UPDATE_PERSON = "UPDATE persons" +
            " SET personName = ?, surname = ?, phoneNumber = ?, email = ?" +
            " WHERE id = ?";
    private static final String SELECT_ALL_PERSONS = "SELECT * FROM persons;";
    private static final String SELECT_PERSON_BY_ID = "SELECT * FROM persons WHERE id = ?";
    private static final String CHANGE_PERSON_DATA_TO_DELETED = "UPDATE persons" +
            " SET personname ='USUNIĘTO'," +
            "    surname='USUNIĘTO'," +
            "    phoneNumber='USUNIĘTO'," +
            "    email='USUNIĘTO'" +
            " WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getLong("id"));
        person.setName(resultSet.getString("personName"));
        person.setSurname(resultSet.getString("surname"));
        person.setPhoneNumber(resultSet.getString("phoneNumber"));
        person.setEmail(resultSet.getString("email"));
        return person;
    }

    @Override
    public List<Person> getAllPersons() {
        return jdbcTemplate.query(SELECT_ALL_PERSONS,
                (resultSet, i) -> mapRow(resultSet, 0));
    }

    @Override
    public Person getById(long personId) {
        return jdbcTemplate.queryForObject(SELECT_PERSON_BY_ID,
                new Object[]{personId},
                PersonDaoImpl::mapRow);
    }

    @Override
    public int update(Person person) {
        Object[] params = new Object[]{
                person.getName(),
                person.getSurname(),
                person.getPhoneNumber(),
                person.getEmail(),
                person.getId()
        };
        return jdbcTemplate.update(UPDATE_PERSON, params);
    }

    @Override
    public boolean delete(long personId) {
        return jdbcTemplate.update(CHANGE_PERSON_DATA_TO_DELETED, personId) == 1;
    }
}
