package pl.wydarzenia.eventManagement.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.wydarzenia.eventManagement.model.Event;

@Component
public class EventValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Event.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Event event = (Event) target;
        if (event.getRodoClause() != null && !event.getRodoClause()) {
            errors.rejectValue("rodoClause", "createEvent.validation.rodoClause.message");
        }
    }
}
