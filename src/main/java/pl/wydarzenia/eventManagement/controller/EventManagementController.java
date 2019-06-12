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
import pl.wydarzenia.person.service.PersonService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EventManagementController {
    private EventService eventService;
    private PersonService personService;

    @Autowired
    public EventManagementController(EventService eventService, PersonService personService) {
        this.eventService = eventService;
        this.personService = personService;
    }

    @GetMapping("/zarzadzanieWydarzeniami")
    public String getEventManagementPage(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        model.addAttribute("persons", personService.getAllPersons());
        return "events_management";
    }

    @GetMapping("/zarzadzanieWydarzeniami/wydarzenie")
    public String getEventManagementView(
            Model model,
            @RequestParam("id") long eventId) {
        Event event = eventService.getEventForEdit(eventId);
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
        boolean eventSaveSuccess = eventService.updateEvent(event) == 1;
        return eventSaveSuccess ? "redirect:/zarzadzanieWydarzeniami" : "events_management_event";
    }

    @DeleteMapping("/zarzadzanieWydarzeniami/wydarzenie/usun")
    public ResponseEntity deleteEvent(@RequestParam("id") long eventId) {
        Event eventToRemove = eventService.getEventById(eventId);
        if (eventToRemove == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if (eventService.deleteEventWithId(eventId)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
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
