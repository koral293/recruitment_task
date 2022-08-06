package dataproviders;

import containers.User;
import generators.RandomNumberGenerator;
import generators.RandomStringGenerator;

import java.util.ArrayList;
import java.util.List;

public class Users {

    public static String TEST_USER = "UserX";

    public static User getDefaultUser() {
        return User.builder()
                .username("test")
                .password("abc123")
                .build();
    }

    public static User getTestUser() {
        return User.builder()
                .id(RandomNumberGenerator.getRandomInt())
                .username(TEST_USER)
                .firstName("Jack")
                .lastName("Sparrow")
                .email("jacksparrow@pirates.com")
                .password("jack_sparrow11")
                .phone("123-456-789")
                .userStatus(0)
                .build();
    }

    public static List<User> getRanodmUsers(int ammount) {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < ammount; i++){
            users.add(Users.getRandomUser());
        }
        return users;
    }

    public static User getRandomUser() {
        return User.builder()
                .id(RandomNumberGenerator.getRandomInt())
                .username(RandomStringGenerator.getRandomUserName())
                .firstName(RandomStringGenerator.getRandomFirstName())
                .lastName(RandomStringGenerator.getRandomLastName())
                .email(RandomStringGenerator.getRandomEmail())
                .password(RandomStringGenerator.getRandomPassword())
                .phone("313-212-414")
                .userStatus(0)
                .build();
    }


}
