package pl.wydarzenia.eventManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wydarzenia.eventManagement.service.EventService;

@Controller
public class EventManagementController {
    private EventService eventService;

    @Autowired
    public EventManagementController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("wydarzenia/zarzadzanie")
    public String getEventManagementPage(Model model) {
        model.addAttribute("newEvents", eventService.getAllEvents());
        return "events_management";
    }
}
