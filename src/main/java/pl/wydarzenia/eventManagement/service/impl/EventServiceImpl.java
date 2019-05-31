package pl.wydarzenia.eventManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.model.EventCategory;
import pl.wydarzenia.eventManagement.model.EventPlace;
import pl.wydarzenia.eventManagement.model.EventStatus;
import pl.wydarzenia.eventManagement.service.EventService;
import pl.wydarzenia.utils.test.TestHelper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private List<Event> events = TestHelper.getTestEvents();

    @Autowired
    public List<Event> getAcceptedEvents() {
        return events
                .stream()
                .filter(event -> event.getStatus().equals(EventStatus.Zaakceptowany))
                .collect(Collectors.toList());
    }

    @Autowired
    public List<EventCategory> getCategories() {
        return Arrays.asList(
                new EventCategory("01", "Uroczystość"),
                new EventCategory("02", "Spotkanie"),
                new EventCategory("03", "Naukowe"),
                new EventCategory("04", "Kulturalne"),
                new EventCategory("05", "Sportowe"));
    }

    @Autowired
    public List<EventPlace> getPlaces() {
        return Arrays.asList(
                new EventPlace("01", "Sala wykładowa"),
                new EventPlace("02", "Pokój biurowy"),
                new EventPlace("03", "Hala sportowa"),
                new EventPlace("04", "Biblioteka"),
                new EventPlace("05", "Labolatorium"),
                new EventPlace("06", "Sala komputerowa"),
                new EventPlace("07", "Nie określono"));
    }

    @Override
    public Event getEventById(long eventId) {
        return events
                .stream()
                .filter(event -> event.getId() == eventId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Event> getAllEvents() {
        return events;
    }
}
