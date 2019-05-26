package pl.wydarzenia.eventManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.model.EventCategory;
import pl.wydarzenia.eventManagement.model.EventPlace;
import pl.wydarzenia.eventManagement.model.EventStatus;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private List<Event> events = Arrays.asList(
            new Event("Nazwa 1",
                    EventStatus.NEW,
                    "01",
                    "01",
                    "Organizator 1",
                    new Date(1000),
                    "Opis 1",
                    15,
                    "komentarz 1",
                    "Jan",
                    "Kowalski",
                    "123456789",
                    "jan@kowalski.pl",
                    true,
                    false,
                    false),
            new Event("Nazwa 2",
                    EventStatus.NEW,
                    "01",
                    "01",
                    "Organizator 1",
                    new Date(1000),
                    "Opis 1",
                    15,
                    "komentarz 1",
                    "Jan",
                    "Kowalski",
                    "123456789",
                    "jan@kowalski.pl",
                    true,
                    false,
                    false),
            new Event("Nazwa 3",
                    EventStatus.ACCEPTED,
                    "01",
                    "01",
                    "Organizator 1",
                    new Date(1000),
                    "Opis 1",
                    15,
                    "komentarz 1",
                    "Jan",
                    "Kowalski",
                    "123456789",
                    "jan@kowalski.pl",
                    true,
                    false,
                    false),
            new Event("Nazwa 4",
                    EventStatus.ACCEPTED,
                    "01",
                    "01",
                    "Organizator 1",
                    new Date(1000),
                    "Opis 1",
                    15,
                    "komentarz 1",
                    "Jan",
                    "Kowalski",
                    "123456789",
                    "jan@kowalski.pl",
                    true,
                    false,
                    false));

    @Autowired
    public List<Event> getAcceptedEvents() {
        return events
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
                new EventPlace("05", "Labolatorium"),
                new EventPlace("06", "Sala komputerowa"),
                new EventPlace("07", "Nie określono"));
    }
}
