package pl.wydarzenia.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wydarzenia.person.model.Person;
import pl.wydarzenia.person.service.PersonService;

import javax.validation.Valid;

@Controller
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/zarzadzanieDanymiOsobowymi/osoba")
    public String getEventManagementView(
            Model model,
            @RequestParam("id") long personId) {
        Person person = personService.getPersonById(personId);
        model.addAttribute("person", person);
        return "person_edit";
    }


    @PostMapping("/zarzadzanieDanymiOsobowymi/osoba/zapisz")
    public String savePersonEdit(
            @Valid @ModelAttribute Person person,
            BindingResult result) {
        if (result.hasErrors()) {
            return "person_edit";
        }
        // TODO: save
        int personId = (int) person.getId();
        personService.getAllPersons().set(personId - 1, person);

        return "redirect:/wydarzenia/zarzadzanie";
    }


    @DeleteMapping("/zarzadzanieDanymiOsobowymi/osoba/usun")
    public ResponseEntity deletePerson(@RequestParam("id") long personId) {
        // TODO: delete
        Person personToRemove = personService.getPersonById(personId);
        if (personToRemove == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        personService.getAllPersons().remove(personToRemove);
        return new ResponseEntity(HttpStatus.OK);
    }
}
