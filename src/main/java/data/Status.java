package data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    AVAILABLE("available"),
    UNAVAILABLE("unavailable"),
    SOLD("sold"),
    PENDING("pending");

    String value;

}