package pl.wydarzenia.eventManagement.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.wydarzenia.eventManagement.model.Event;
import pl.wydarzenia.eventManagement.model.EventCategory;
import pl.wydarzenia.eventManagement.model.EventPlace;

import static pl.wydarzenia.utils.StringUtils.isValidDate;

@Component
public class EventValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Event.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Event event = (Event) target;
        Boolean rodoClause = event.getRodoClause();
        if (rodoClause != null && !rodoClause) {
            errors.rejectValue("rodoClause", "createEvent.validation.rodoClause.message");
        }

        String category = event.getCategory();
        if (category != null && !EventCategory.isValid(category)) {
            errors.rejectValue("category", "createEvent.validation.category.message");
        }

        String place = event.getPlace();
        if (place != null && !EventPlace.isValid(place)) {
            errors.rejectValue("place", "createEvent.validation.place.message");
        }

        String dateOfTheEvent = event.getDateOfTheEvent();
        if (dateOfTheEvent != null && !isValidDate(dateOfTheEvent)) {
            errors.rejectValue("dateOfTheEvent", "createEvent.validation.dateOfTheEvent");
        }

        Boolean regulations = event.getRegulations();
        if (regulations != null && !regulations) {
            errors.rejectValue("regulations", "createEvent.validation.regulations.message");
        }
    }
}
