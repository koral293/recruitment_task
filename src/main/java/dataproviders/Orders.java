package dataproviders;

import containers.Order;
import generators.RandomNumberGenerator;
import generators.RandomStringGenerator;

import java.util.Date;

public class Orders {

    public static Order getRandomOrder() {
        Date date = new Date();
        date = new Date(date.getTime() + (1000 * 60 * 60 * 24));
        return Order.builder()
                .id(RandomNumberGenerator.getRandomInt(10)+1)
                .petId(RandomNumberGenerator.getRandomInt(10)+1)
                .quantity(RandomNumberGenerator.getRandomInt(5)+1)
                .shipDate(date.toString())
                .status(RandomStringGenerator.getRandomOrderStatus())
                .complete(false)
                .build();
    }

}
