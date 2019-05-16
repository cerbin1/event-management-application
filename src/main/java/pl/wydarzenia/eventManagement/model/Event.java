package pl.wydarzenia.eventManagement.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class Event {
    @NotEmpty
//    @Size(min = 2, max = 20)
    private String name;

    //    @NotEmpty
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
