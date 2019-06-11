package pl.wydarzenia.eventManagement.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.wydarzenia.eventManagement.dao.EventDao;
import pl.wydarzenia.eventManagement.model.Event;

import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {
    private static final String SELECT_ALL_EVENTS = "SELECT * FROM events;";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EventDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Event> getAllEvents() {
        return jdbcTemplate.query(SELECT_ALL_EVENTS, (resultSet, i) -> {
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
        });
    }
}
