package pl.wydarzenia.eventManagement.service;

import pl.wydarzenia.eventManagement.model.EventCategory;

import java.util.List;

public interface EventService {
    List<EventCategory> getCategories();
}
