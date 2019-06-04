package pl.wydarzenia.eventManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

import static pl.wydarzenia.utils.StringUtils.EMAIL_REGEX;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {
    private long id;

    @NotEmpty(message = "To pole nie może być puste!")
    @Size(min = 2, max = 30, message = "To pole musi mieć pomiędzy 2 a 30 znaków!")
    private String name;

    private String status;

    @NotEmpty(message = "To pole nie może być puste!")
    private String category;

    @NotEmpty(message = "To pole nie może być puste!")
    private String place;

    @NotEmpty(message = "To pole nie może być puste!")
    private String organizationName;

    @NotNull(message = "To pole nie może być puste!")
    private String dateOfTheEvent;

    @NotEmpty(message = "To pole nie może być puste!")
    private String description;

    @NotNull(message = "To pole nie może być puste!")
    @Min(value = 2, message = "Minimalna liczba uczestników to 2!")
    @Max(value = 1000, message = "Maksymalna liczba uczestników to 1000!")
    private Integer plannedNumberOfParticipants;

    @Size(max = 1000, message = "To pole może miec maksymalnie 1000 znaków!")
    private String comments;

    @NotEmpty(message = "To pole nie może być puste!")
    private String organizerName;

    @NotEmpty(message = "To pole nie może być puste!")
    private String organizerSurname;

    @NotEmpty(message = "To pole nie może być puste!")
    @Pattern(regexp = "(^$|[0-9]{7,10})", message = "Proszę podać poprawny numer telefonu, który powinien się składać z 7-10 cyfr!")
    private String organizerPhoneNumber;

    @Pattern(regexp = EMAIL_REGEX, message = "Proszę podać poprawny adres email!")
    private String organizerEmail;

    @NotNull(message = "Do zgłoszenia wydarzenia wymagana jest potwierdzona klauzula RODO!")
    private Boolean rodoClause = null;

    private Boolean promotionalCampaign = false;

    private Boolean photograph = false;
}
