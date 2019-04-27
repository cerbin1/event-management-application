package pl.wydarzenia.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Event {
    private String name;
    private String organizerName;
    private LocalDateTime dateOfTheEvent;
    private String description;
    private int plannedNumberOfParticipants;
    private Organizer organizer;
}
