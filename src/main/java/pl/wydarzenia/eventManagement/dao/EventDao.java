package pl.wydarzenia.eventManagement.dao;

import pl.wydarzenia.eventManagement.model.Event;

import java.util.List;

public interface EventDao {
    List<Event> getAllEvents();
}
