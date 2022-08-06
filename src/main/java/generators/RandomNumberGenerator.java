package generators;

import java.util.Random;

public class RandomNumberGenerator {

    public static int getRandomInt(){
        Random random = new Random();
        return random.nextInt(10000000);
    }

    public static int getRandomInt(int range){
        Random random = new Random();
        return random.nextInt(range);
    }

}
