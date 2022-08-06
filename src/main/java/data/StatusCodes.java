package data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCodes {

    STATUS_200(200),
    STATUS_404(404);

    int value;

}
