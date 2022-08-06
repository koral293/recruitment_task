package rest.assured;

import containers.Order;
import containers.Pet;
import containers.User;
import dataproviders.Orders;
import dataproviders.Pets;
import dataproviders.Users;
import io.restassured.RestAssured;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import rest.PetResponses;
import rest.StoreResponses;
import rest.UserResponses;

@Log4j2
public class TestPetStore_Test {

    @Before
    public void setUp() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void testPetStore() {
        UserResponses.loginWithUser(Users.getDefaultUser());
        User user = Users.getRandomUser();
        UserResponses.createNewUser(user);
        UserResponses.loginWithUser(user);
        Pet pet = Pets.getRandomPet();
        PetResponses.addPet(pet);
        StoreResponses.getInventory();
        PetResponses.deletePet(pet.getId());
        /* Service keeps returning 500
        Order order = Orders.getRandomOrder();
        StoreResponses.placeOrder(order);
        StoreResponses.findOrder(order.getId());
        StoreResponses.deleteOrder(order.getId());*/
    }

}