package pl.wydarzenia.eventManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.model.EventCategory;
import pl.wydarzenia.eventManagement.model.EventPlace;
import pl.wydarzenia.eventManagement.model.EventStatus;
import pl.wydarzenia.eventManagement.service.EventService;

import java.util.List;

@Controller
public class EventManagementController {
    private EventService eventService;

    @Autowired
    public EventManagementController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("wydarzenia/zarzadzanie")
    public String getEventManagementPage(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events_management";
    }

    @GetMapping("/zarzadzanieWydarzeniami/wydarzenie")
    public String getEventManagementView(
            Model model,
            @RequestParam long eventId) {
        Event event = eventService.getEventById(eventId);
        model.addAttribute("event", event);
        return "events_management_event";
    }

    @PostMapping("/zarzadzanieWydarzeniami/wydarzenie/zapisz")
    public String saveEventEdit(Event event) {
        // TODO: save
        return "redirect:/wydarzenia/zarzadzanie";
    }

    @ModelAttribute("eventCategories")
    public List<EventCategory> getEventCategories() {
        return eventService.getCategories();
    }

    @ModelAttribute("eventPlaces")
    public List<EventPlace> getEventPlaces() {
        return eventService.getPlaces();
    }
    @ModelAttribute("eventStatuses")
    public List<EventStatus> getEventStatuses() {
        return eventService.getStatuses();
    }
}
