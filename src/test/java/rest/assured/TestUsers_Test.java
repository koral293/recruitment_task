package rest.assured;

import containers.User;
import dataproviders.Users;
import io.restassured.RestAssured;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import rest.UserResponses;

import java.util.List;

@Log4j2
public class TestUsers_Test {

    @Before
    public void setUp() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void testUserFunctionality() {
        UserResponses.loginWithUser(Users.getDefaultUser());
        UserResponses.createNewUser(Users.getTestUser());
        User updatedUser = Users.getTestUser();
        updatedUser.setLastName("updatedTestLastName");
        UserResponses.updateUserWithVerification(Users.getTestUser(), updatedUser);
        UserResponses.deleteUser(updatedUser);
    }

    @Test
    public void createAndDeleteUsers() {
        List<User> users = Users.getRanodmUsers(15);
        UserResponses.loginWithUser(Users.getDefaultUser());
        UserResponses.creatListOfUsers(users);
        for (User user : users) {
            UserResponses.verifyUser(user.getUsername());
        }
        for (User user : users) {
            UserResponses.deleteUser(user);
            UserResponses.verifyDeletedUser(user.getUsername());
        }
    }

}