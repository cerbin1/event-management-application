package pl.wydarzenia.eventManagement.model;

import lombok.Getter;
import lombok.Setter;

public enum EventStatus {
    Nowy("01"), Zaakceptowany("02"), Odrzucony("03");

    @Getter
    @Setter
    private String value;

    EventStatus(String value) {
        this.value = value;
    }
}
