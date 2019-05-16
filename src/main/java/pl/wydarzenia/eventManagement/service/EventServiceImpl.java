package pl.wydarzenia.eventManagement.service;

import org.springframework.stereotype.Service;
import pl.wydarzenia.eventManagement.model.EventCategory;

import java.util.Arrays;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    public List<EventCategory> getCategories() {
        return Arrays.asList(
                new EventCategory("01", "Uroczystość"),
                new EventCategory("02", "Spotkanie"),
                new EventCategory("03", "Naukowe"),
                new EventCategory("04", "Kulturalne"),
                new EventCategory("05", "Sportowe"));
    }
}
