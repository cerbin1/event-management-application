package pl.wydarzenia.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wydarzenia.eventManagement.service.EventService;

@Controller
public class HomeController {
    private EventService eventService;

    @Autowired
    public HomeController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("acceptedEvents", eventService.getAcceptedEvents());
        return "home";
    }
}
