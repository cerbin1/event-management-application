package pl.wydarzenia.eventManagement.service;

import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.model.EventCategory;
import pl.wydarzenia.eventManagement.model.EventPlace;
import pl.wydarzenia.eventManagement.model.EventStatus;

import java.util.List;

public interface EventService {
    List<Event> getAcceptedEvents();

    List<EventCategory> getCategories();

    List<EventPlace> getPlaces();

    List<EventStatus> getStatuses();

    Event getEventById(long eventId);

    List<Event> getAllEvents();

    int saveEvent(Event event);

    int updateEvent(Event event);

    boolean deleteEventWithId(long eventId);

    Event getEventForEdit(long eventId);
}
