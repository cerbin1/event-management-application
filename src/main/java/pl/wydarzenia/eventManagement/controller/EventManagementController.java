package pl.wydarzenia.eventManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.model.EventCategory;
import pl.wydarzenia.eventManagement.model.EventPlace;
import pl.wydarzenia.eventManagement.service.EventService;
import pl.wydarzenia.eventManagement.validator.EventValidator;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EventManagementController {
    private final EventService eventService;

    @Autowired
    public EventManagementController(EventService eventService) {
        this.eventService = eventService;
    }

    @ModelAttribute("eventCategories")
    public List<EventCategory> getEventCategories() {
        return eventService.getCategories();
    }

    @ModelAttribute("eventPlaces")
    public List<EventPlace> getEventPlaces() {
        return eventService.getPlaces();
    }

    @GetMapping("wydarzenia/dodaj")
    public String getEventCreationForm(Model model) {
        model.addAttribute("event", new Event());
        return "create_event";
    }

    @PostMapping("/test")
    public String submitEventCreationForm(
            @Valid @ModelAttribute Event event,
            BindingResult result) {
        EventValidator eventValidator = new EventValidator();
        eventValidator.validate(event, result);
        if (result.hasErrors()) {
            return "create_event";
        }
        return "todo"; // TODO:save
    }
}
