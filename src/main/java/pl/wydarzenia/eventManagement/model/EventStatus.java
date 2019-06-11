package pl.wydarzenia.eventManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class EventStatus {
    public static final String NEW = "01";
    public static final String ACCEPTED = "02";
    public static final String REJECTED = "03";
    public static final String STATUS_ACCEPTED_NAME = "Zaakceptowany";

    @Getter
    @Setter
    private String value;

    @Getter
    @Setter
    private String name;
}
