package pl.wydarzenia.eventManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.service.EventService;
import pl.wydarzenia.eventManagement.validator.EventValidator;

import javax.validation.Valid;

import static pl.wydarzenia.utils.SpringUtils.getActualLocale;

@Controller
public class EventManagementController {
    private final EventService eventService;

    @Autowired
    public EventManagementController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("wydarzenia/dodaj")
    public String getEventCreationForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("eventCategories",
                eventService.getCategoriesForLocale(getActualLocale()));
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
        System.out.println("Bez bledow");
        return "create_event"; // TODO:save
    }
}
