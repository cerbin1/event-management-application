package pl.wydarzenia.person.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import static pl.wydarzenia.utils.StringUtils.EMAIL_REGEX;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private  long id;

    @NotEmpty(message = "To pole nie może być puste!")
    private  String name;

    @NotEmpty(message = "To pole nie może być puste!")
    private  String surname;

    @Pattern(regexp = "(^$|[0-9]{7,10})", message = "Proszę podać poprawny numer telefonu, który powinien się składać z 7-10 cyfr!")
    private  String phoneNumber;

    @Pattern(regexp = EMAIL_REGEX, message = "Proszę podać poprawny adres email!")
    private  String email;
}
