package pl.wydarzenia.eventManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.model.EventCategory;
import pl.wydarzenia.eventManagement.model.EventPlace;
import pl.wydarzenia.eventManagement.service.EventService;
import pl.wydarzenia.eventManagement.validator.EventValidator;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EventManagementController {
    private final EventService eventService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true));
    }

    @Autowired
    public EventManagementController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("wydarzenia/dodaj")
    public String getEventCreationForm(Model model) {
        model.addAttribute("event", new Event());
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

    @PostMapping("/wydarzenie/dodaj/wyslij")
    public String submit(
            @Valid @ModelAttribute Event event,
            BindingResult result) {
        if (result.hasErrors()) {
            return "create_event";
        }

        // TODOO: save
        return "redirect:/";
    }

    @ModelAttribute("eventCategories")
    public List<EventCategory> getEventCategories() {
        return eventService.getCategories();
    }

    @ModelAttribute("eventPlaces")
    public List<EventPlace> getEventPlaces() {
        return eventService.getPlaces();
    }
}
