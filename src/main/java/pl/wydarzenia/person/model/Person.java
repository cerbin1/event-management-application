package pl.wydarzenia.person.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import static pl.wydarzenia.utils.StringUtils.EMAIL_REGEX;

@Data
@AllArgsConstructor
public class Person {
    private final long id;

    @NotEmpty(message = "To pole nie może być puste!")
    private final String name;

    @NotEmpty(message = "To pole nie może być puste!")
    private final String surname;

    @Pattern(regexp = "(^$|[0-9]{7,10})", message = "Proszę podać poprawny numer telefonu, który powinien się składać z 7-10 cyfr!")
    private final String phoneNumber;

    @Pattern(regexp = EMAIL_REGEX, message = "Proszę podać poprawny adres email!")
    private final String email;
}
