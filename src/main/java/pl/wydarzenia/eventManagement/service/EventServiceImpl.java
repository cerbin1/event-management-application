package pl.wydarzenia.eventManagement.service;

import org.springframework.stereotype.Service;
import pl.wydarzenia.eventManagement.model.EventCategory;
import pl.wydarzenia.eventManagement.model.EventPlace;

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
