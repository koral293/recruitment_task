package rest.assured;

import containers.Pet;
import dataproviders.Pets;
import dataproviders.Users;
import io.restassured.RestAssured;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import rest.PetResponses;
import rest.UserResponses;

@Log4j2
public class TestPets_Test {

    @Before
    public void setUp() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void testPetFunctionality(){
        UserResponses.loginWithUser(Users.getDefaultUser());
        Pet pet = Pets.getRandomPet();
        PetResponses.addPet(pet);
        PetResponses.verifyPet(pet.getId());
        Pet newPet = Pets.getRandomPet();
        newPet.setId(pet.getId());
        PetResponses.updatePetWithVerification(pet, newPet);
        PetResponses.deletePet(pet.getId());
    }

}