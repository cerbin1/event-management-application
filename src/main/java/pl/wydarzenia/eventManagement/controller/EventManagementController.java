package pl.wydarzenia.eventManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.model.EventCategory;
import pl.wydarzenia.eventManagement.model.EventPlace;
import pl.wydarzenia.eventManagement.model.EventStatus;
import pl.wydarzenia.eventManagement.service.EventService;

import javax.validation.Valid;
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
            @RequestParam("id") long eventId) {
        Event event = eventService.getEventById(eventId);
        model.addAttribute("event", event);
        return "events_management_event";
    }

    @PostMapping("/zarzadzanieWydarzeniami/wydarzenie/zapisz")
    public String saveEventEdit(
            @Valid @ModelAttribute Event event,
            BindingResult result) {
        if (result.hasErrors()) {
            return "events_management_event";
        }
        // TODO: save
        int eventId = (int) event.getId();
        eventService.getAllEvents().set(eventId - 1, event);
        return "redirect:/wydarzenia/zarzadzanie";
    }

    @DeleteMapping("/zarzadzanieWydarzeniami/wydarzenie/usun")
    public ResponseEntity deleteEvent(@RequestParam("id") long eventId) {
        // TODO: delete
        Event eventToRemove = eventService.getEventById(eventId);
        if (eventToRemove == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        eventService.getAllEvents().remove(eventToRemove);
        return new ResponseEntity(HttpStatus.OK);
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
