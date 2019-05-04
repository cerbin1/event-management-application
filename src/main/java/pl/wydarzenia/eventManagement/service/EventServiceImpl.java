package pl.wydarzenia.eventManagement.service;

import org.springframework.stereotype.Service;
import pl.wydarzenia.eventManagement.model.EventCategory;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class EventServiceImpl implements EventService {
    @Override
    public List<EventCategory> getCategoriesForLocale(Locale locale) {
        if (locale.toLanguageTag().equals("en")) {
            return getCategoriesInEnglish();
        } else if (locale.toLanguageTag().equals("pl")) {
            return getCategoriesInPolish();
        } else {
            throw new RuntimeException("Wrong Locale");
        }
    }

    private List<EventCategory> getCategoriesInEnglish() {
        return Arrays.asList(
                new EventCategory("01", "Celebrations"),
                new EventCategory("02", "Meetings"),
                new EventCategory("03", "Scientific"),
                new EventCategory("04", "Cultural"),
                new EventCategory("05", "Sports"));
    }

    private List<EventCategory> getCategoriesInPolish() {
        return Arrays.asList(
                new EventCategory("01", "Uroczystości"),
                new EventCategory("02", "Spotkania"),
                new EventCategory("03", "Naukowe"),
                new EventCategory("04", "Kulturalne"),
                new EventCategory("05", "Sportowe"));
    }
}
