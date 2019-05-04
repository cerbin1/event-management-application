package pl.wydarzenia.eventManagement.service;

import pl.wydarzenia.eventManagement.model.EventCategory;

import java.util.List;
import java.util.Locale;

public interface EventService {
    List<EventCategory> getCategoriesForLocale(Locale locale);
}
