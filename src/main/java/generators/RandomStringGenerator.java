package generators;

import containers.Category;
import data.Categories;
import data.Names;
import data.OrderStatus;
import data.Status;

import java.util.Random;

public class RandomStringGenerator {

    public static String getRandomFirstName() {
        Random random = new Random();
        return Names.names.get(random.nextInt(100)).split(" ")[0];
    }

    public static String getRandomLastName() {
        Random random = new Random();
        return Names.names.get(random.nextInt(Names.names.size())).split(" ")[1];
    }

    public static String getRandomUserName() {
        Random random = new Random();
        return String.format("%s_%s%s", getRandomFirstName(), getRandomLastName(), random.nextInt(100000));
    }

    public static String getRandomEmail() {
        return String.format("%s_%s@mail.com", getRandomFirstName(), getRandomLastName());
    }

    public static String getRandomPassword() {
        Random random = new Random();
        return String.format("%s_%s_test", getRandomLastName(), random.nextInt(100000));
    }

    public static Category getRandomCategory() {
        Random random = new Random();
        Categories category = Categories.values()[random.nextInt(Categories.values().length)];
        return Category.builder()
                .id(category.getId())
                .name(category.getValue())
                .build();
    }

    public static String getRandomOrderStatus() {
        Random random = new Random();
        OrderStatus status = OrderStatus.values()[random.nextInt(OrderStatus.values().length)];
        return status.getValue();
    }

}
