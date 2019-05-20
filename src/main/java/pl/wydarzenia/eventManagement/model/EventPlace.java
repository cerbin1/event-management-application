package pl.wydarzenia.eventManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static java.util.Arrays.asList;

@AllArgsConstructor
public class EventPlace {
    private static final List<String> EVENT_PLACE_VALUES = asList("01", "02", "03", "04", "05", "06", "07");
    @Getter
    @Setter
    private String value;

    @Getter
    @Setter
    private String name;

    public static boolean isValid(String place) {
        return EVENT_PLACE_VALUES.contains(place);
    }
}
