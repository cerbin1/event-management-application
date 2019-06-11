package pl.wydarzenia.eventManagement.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.wydarzenia.eventManagement.dao.EventDao;
import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.model.EventStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static pl.wydarzenia.person.dao.impl.PersonDaoImpl.UPDATE_PERSON;

@Repository
public class EventDaoImpl implements EventDao {
    private static final String SELECT_ALL_EVENTS = "SELECT * FROM events;";

    private static final String INSERT_NEW_EVENT = "INSERT INTO events (name, status, category, place," +
            " organizationname, dateoftheevent, description, plannednumberofparticipants, comments," +
            " regulations, rodoclause, promotionalcampaign, photograph, personid) VALUES (" +
            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String INSERT_NEW_PERSON = "INSERT INTO persons " +
            "(personName, surname, phoneNumber, email)" +
            " VALUES (?, ?, ?, ?) " +
            "RETURNING id";
    private static final String SELECT_EVENT_BY_ID = "SELECT * FROM events event" +
            " LEFT JOIN persons person on event.personId=person.id" +
            " WHERE event.id = ?";

    private static final String UPDATE_EVENT = "UPDATE events" +
            " SET name=?," +
            "    status=?," +
            "    category=?," +
            "    place=?," +
            "    organizationName=?," +
            "    dateOfTheEvent=?," +
            "    description=?," +
            "    plannedNumberOfParticipants=?," +
            "    comments=?," +
            "    regulations=?," +
            "    rodoClause=?," +
            "    promotionalCampaign=?," +
            "    photograph=?" +
            " WHERE id =?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EventDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Event mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getLong("id"));
        event.setName(resultSet.getString("name"));
        event.setStatus(resultSet.getString("status"));
        event.setCategory(resultSet.getString("category"));
        event.setPlace(resultSet.getString("place"));
        event.setOrganizationName(resultSet.getString("organizationName"));
        event.setDateOfTheEvent(resultSet.getString("dateOfTheEvent"));
        event.setDescription(resultSet.getString("description"));
        event.setPlannedNumberOfParticipants(resultSet.getInt("plannedNumberOfParticipants"));
        event.setComments(resultSet.getString("comments"));
        event.setRegulations(resultSet.getBoolean("regulations"));
        event.setRodoClause(resultSet.getBoolean("rodoClause"));
        event.setPromotionalCampaign(resultSet.getBoolean("promotionalCampaign"));
        event.setPhotograph(resultSet.getBoolean("photograph"));
        return event;
    }

    private static Event mapRowWithPerson(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getLong("id"));
        event.setName(resultSet.getString("name"));
        event.setStatus(resultSet.getString("status"));
        event.setCategory(resultSet.getString("category"));
        event.setPlace(resultSet.getString("place"));
        event.setOrganizationName(resultSet.getString("organizationName"));
        event.setDateOfTheEvent(resultSet.getString("dateOfTheEvent"));
        event.setDescription(resultSet.getString("description"));
        event.setPlannedNumberOfParticipants(resultSet.getInt("plannedNumberOfParticipants"));
        event.setComments(resultSet.getString("comments"));
        event.setRegulations(resultSet.getBoolean("regulations"));
        event.setRodoClause(resultSet.getBoolean("rodoClause"));
        event.setPromotionalCampaign(resultSet.getBoolean("promotionalCampaign"));
        event.setPhotograph(resultSet.getBoolean("photograph"));
        event.setOrganizerName(resultSet.getString("personName"));
        event.setOrganizerSurname(resultSet.getString("surname"));
        event.setOrganizerPhoneNumber(resultSet.getString("phoneNumber"));
        event.setOrganizerEmail(resultSet.getString("email"));
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        return jdbcTemplate.query(SELECT_ALL_EVENTS,
                (resultSet, i) -> mapRow(resultSet, 0));
    }

    @Override
    @Transactional
    public int save(Event event) {
        Object[] addPersonParams = new Object[]{
                event.getOrganizerName(),
                event.getOrganizerSurname(),
                event.getOrganizerPhoneNumber(),
                event.getOrganizerEmail()
        };

        Integer personId = jdbcTemplate.queryForObject(INSERT_NEW_PERSON, addPersonParams, Integer.class);
        if (personId == null) {
            throw new RuntimeException("Error while trying insert new person!");
        }

        Object[] addEventParams = new Object[]{
                event.getName(),
                EventStatus.NEW,
                event.getCategory(),
                event.getPlace(),
                event.getOrganizationName(),
                event.getDateOfTheEvent(),
                event.getDescription(),
                event.getPlannedNumberOfParticipants(),
                event.getComments(),
                event.getRegulations(),
                event.getRodoClause(),
                event.getPromotionalCampaign(),
                event.getPhotograph(),
                personId
        };
        return jdbcTemplate.update(INSERT_NEW_EVENT, addEventParams);
    }

    @Override
    public Event getById(long eventId) {
        return jdbcTemplate.queryForObject(
                SELECT_EVENT_BY_ID,
                new Object[]{eventId},
                EventDaoImpl::mapRowWithPerson);
    }

    @Override
    @Transactional
    public int update(Event event) {
        Integer eventPersonId = jdbcTemplate.queryForObject("SELECT personId from events where id=?",
                new Object[]{event.getId()},
                Integer.class);
        if (eventPersonId == null) {
            throw new RuntimeException("Error while trying update event!");
        }
        Object[] updatePersonParams = new Object[]{
                event.getOrganizerName(),
                event.getOrganizerSurname(),
                event.getOrganizerPhoneNumber(),
                event.getOrganizerEmail(),
                eventPersonId
        };
        boolean updatePerson = jdbcTemplate.update(UPDATE_PERSON, updatePersonParams) == 1;
        if (!updatePerson) {
            throw new RuntimeException("Error while trying update event!");
        }

        Object[] params = new Object[]{
                event.getName(),
                event.getStatus(),
                event.getCategory(),
                event.getPlace(),
                event.getOrganizationName(),
                event.getDateOfTheEvent(),
                event.getDescription(),
                event.getPlannedNumberOfParticipants(),
                event.getComments(),
                event.getRegulations(),
                event.getRodoClause(),
                event.getPromotionalCampaign(),
                event.getPhotograph(),
                event.getId()
        };
        return jdbcTemplate.update(UPDATE_EVENT, params);
    }
}
