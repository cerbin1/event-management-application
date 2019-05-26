package pl.wydarzenia.eventManagement.model;

import lombok.Getter;
import lombok.Setter;

public enum EventStatus {
    NEW("01"), ACCEPTED("02"), REJECTED("03");

    @Getter
    @Setter
    private String value;

    EventStatus(String value) {
        this.value = value;
    }
}
