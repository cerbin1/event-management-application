package pl.wydarzenia.eventManagement.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class Event {
    @NotEmpty(message = "To pole nie może być puste!")
    @Size(min = 2, max = 30, message = "To pole musi mieć pomiędzy 2 a 30 znaków!")
    private String name;

    @NotEmpty(message = "To pole nie może być puste!")
    private String category;

    //    @NotEmpty
    private String place;

    //    @NotEmpty
    private String organizerName;

    //    @NotEmpty
    private LocalDate dateOfTheEvent;

    //    @NotEmpty
    private String description;

    //    @Size(min = 2, max = 1000)
    private int plannedNumberOfParticipants;

    private String comments;

    //    @Valid
//    @NotEmpty
    private Organizer organizer;
}
