package pl.wydarzenia.utils.test;

import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.model.EventStatus;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestHelper {
    private static final List<Event> events = Arrays.asList(
            new Event(1,
                    "Nazwa 1",
                    EventStatus.ACCEPTED,
                    "01",
                    "01",
                    "Organizator 1",
                    new Date(1000), "Opis 1",
                    15,
                    "komentarz 1",
                    "Jan",
                    "Kowalski",
                    "123456789",
                    "jan@kowalski.pl",
                    true,
                    false,
                    false),
            new Event(2,
                    "Nazwa 2",
                    EventStatus.ACCEPTED,
                    "01",
                    "01",
                    "Organizator 1",
                    new Date(1000), "Opis 1",
                    15,
                    "komentarz 1",
                    "Jan",
                    "Kowalski",
                    "123456789",
                    "jan@kowalski.pl",
                    true,
                    false,
                    false),
            new Event(3,
                    "Nazwa 3",
                    EventStatus.ACCEPTED,
                    "01",
                    "01",
                    "Organizator 1",
                    new Date(1000), "Opis 1",
                    15,
                    "komentarz 1",
                    "Jan",
                    "Kowalski",
                    "123456789",
                    "jan@kowalski.pl",
                    true,
                    false,
                    false),
            new Event(4,
                    "Nazwa 4",
                    EventStatus.ACCEPTED,
                    "01",
                    "01",
                    "Organizator 1",
                    new Date(1000), "Opis 1",
                    15,
                    "komentarz 1",
                    "Jan",
                    "Kowalski",
                    "123456789",
                    "jan@kowalski.pl",
                    true,
                    false,
                    false)
    );

    public static List<Event> getTestEvents() {
        return events;
    }

    public static Event getSingleTestEvent() {
        Event event = new Event();
        event.setId(1);
        event.setName("Szkolenie z programowania");
        event.setCategory("02");
        event.setPlace("02");
        event.setOrganizationName("Codality");
        event.setDescription("Opis wydarzenia");
        event.setPlannedNumberOfParticipants(15);
        event.setComments("uwagi");
        event.setOrganizerName("Jan");
        event.setOrganizerSurname("Nowak");
        event.setOrganizerPhoneNumber("1234567");
        event.setOrganizerEmail("jan@nowak.pl");
        event.setRodoClause(true);
        event.setPromotionalCampaign(true);
        event.setPhotograph(true);
        return event;
    }
}
