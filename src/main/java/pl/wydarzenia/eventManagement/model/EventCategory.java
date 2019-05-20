package pl.wydarzenia.eventManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static java.util.Arrays.asList;

@AllArgsConstructor
public class EventCategory {
    private static final List<String> EVENT_CATEGORY_VALUES = asList("01", "02", "03", "04", "05");

    @Getter
    @Setter
    private String value;

    @Getter
    @Setter
    private String name;

    public static boolean isValid(String category) {
        return EVENT_CATEGORY_VALUES.contains(category);
    }
}
