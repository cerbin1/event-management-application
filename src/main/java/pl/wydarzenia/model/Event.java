package pl.wydarzenia.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Event {
    private String name;
    private String category;
    private String place;
    private String organizerName;
    private LocalDate dateOfTheEvent;
    private String description;
    private int plannedNumberOfParticipants;
    private String comments;
    private Organizer organizer;
}
