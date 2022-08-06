package data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Categories {

    DOG(1, "Dog"),
    CAT(2, "Cat"),
    LIZARD(3, "Lizard"),
    DRAGON(4, "Dragon"),
    MAMMOTH(5, "Mammoth"),
    CAPYBARA(6, "Capybara");

    int id;
    String value;

}
