package data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    PLACED("placed"),
    APPROVED("approved"),
    DELIVERED("delivered");

    String value;

}