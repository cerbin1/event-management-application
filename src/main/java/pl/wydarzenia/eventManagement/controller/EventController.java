package pl.wydarzenia.eventManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.model.EventCategory;
import pl.wydarzenia.eventManagement.model.EventPlace;
import pl.wydarzenia.eventManagement.model.EventStatus;
import pl.wydarzenia.eventManagement.service.EventService;
import pl.wydarzenia.eventManagement.validator.EventValidator;

import javax.validation.Valid;
import java.util.List;

import static pl.wydarzenia.utils.test.TestHelper.getSingleTestEvent;

@Controller
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("wydarzenia/dodaj")
    public String getEventCreationForm(Model model) {
        model.addAttribute("event", getSingleTestEvent());
        return "create_event";
    }

    @PostMapping("wydarzenia/dodaj/podsumowanie")
    public String submitEventCreationForm(
            @Valid @ModelAttribute Event event,
            BindingResult result) {
        EventValidator eventValidator = new EventValidator();
        eventValidator.validate(event, result);
        if (result.hasErrors()) {
            return "create_event";
        }
        return "create_event_summary";
    }

    @PostMapping("wydarzenia/dodaj/wyslij")
    public String submit(
            @Valid @ModelAttribute Event event,
            BindingResult result) {
        if (result.hasErrors()) {
            return "create_event";
        }

        event.setStatus(EventStatus.NEW);

        List<Event> allEvents = eventService.getAllEvents();
        event.setId(allEvents.size() + 1);
        allEvents.add(event);
        // TODO: save
        return "redirect:/";
    }

    @GetMapping("wydarzenie/szczegoly")
    public String getEventDetails(
            Model model,
            @RequestParam long eventId) {
        Event event = eventService.getEventById(eventId);
        model.addAttribute("event", event);
        return "event_details";
    }

    @ModelAttribute("eventCategories")
    public List<EventCategory> getEventCategories() {
        return eventService.getCategories();
    }

    @ModelAttribute("eventPlaces")
    public List<EventPlace> getEventPlaces() {
        return eventService.getPlaces();
    }

    @ModelAttribute("mainPageMapping")
    public String getMainPageMapping() {
        return "/";
    }
}
