package pl.wydarzenia.eventManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wydarzenia.eventManagement.dao.EventDao;
import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.model.EventCategory;
import pl.wydarzenia.eventManagement.model.EventPlace;
import pl.wydarzenia.eventManagement.model.EventStatus;
import pl.wydarzenia.eventManagement.service.EventService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private final EventDao eventDao;

    @Autowired
    public EventServiceImpl(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDao.getAllEvents();
    }

    @Autowired
    public List<Event> getAcceptedEvents() {
        return eventDao.getAllEvents()
                .stream()
                .filter(event -> event.getStatus().equals(EventStatus.ACCEPTED))
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
                new EventPlace("05", "Laboratorium"),
                new EventPlace("06", "Sala komputerowa"),
                new EventPlace("07", "Nie określono"));
    }

    @Autowired
    public List<EventStatus> getStatuses() {
        return Arrays.asList(
                new EventStatus("01", "Nowy"),
                new EventStatus("02", "Zaakceptowany"),
                new EventStatus("03", "Odrzucony"));
    }

    @Override
    public Event getEventById(long eventId) {
        return eventDao.getById(eventId);
    }

    @Override
    public int saveEvent(Event event) {
        return eventDao.save(event);
    }

    @Override
    public int updateEvent(Event event) {
        return eventDao.update(event);
    }

    @Override
    public boolean deleteEventWithId(long eventId) {
        return eventDao.delete(eventId);
    }
}
