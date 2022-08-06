package dataproviders;

import containers.Pet;
import containers.Tag;
import data.Status;
import generators.RandomNumberGenerator;
import generators.RandomStringGenerator;

import java.util.Arrays;
import java.util.Collections;

public class Pets {

    public static Pet getRandomPet() {
        return Pet.builder()
                .id(RandomNumberGenerator.getRandomInt())
                .category(RandomStringGenerator.getRandomCategory())
                .name(RandomStringGenerator.getRandomFirstName())
                .photoUrls(Collections.emptyList())
                .tags(Arrays.asList(Tag.builder()
                        .id(25)
                        .name("Test_tag")
                        .build()))
                .status(Status.AVAILABLE.getValue())
                .build();
    }

}
