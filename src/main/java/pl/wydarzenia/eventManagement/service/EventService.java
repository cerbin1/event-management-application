package pl.wydarzenia.eventManagement.service;

import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.model.EventCategory;
import pl.wydarzenia.eventManagement.model.EventPlace;

import java.util.List;

public interface EventService {
    List<Event> getAcceptedEvents();

    List<EventCategory> getCategories();

    List<EventPlace> getPlaces();
}
