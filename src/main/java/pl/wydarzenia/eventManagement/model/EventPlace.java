package pl.wydarzenia.eventManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class EventPlace {
    @Getter
    @Setter
    private String value;

    @Getter
    @Setter
    private String name;
}
