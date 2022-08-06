package rest;

import containers.Pet;
import data.StatusCodes;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

@UtilityClass
public class PetResponses {

    public void addPet(Pet pet) {
        JSONObject newPet = new JSONObject(pet.getMap());
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(newPet.toJSONString())
                .post("/pet");
        Assert.assertEquals("Pet can't be added!", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "Pet added successfully");
    }

    public void verifyPet(long id) {
        Response response = getPet(id);
        Assert.assertEquals("Pet does not exists!", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "Pet exists");
    }

    public void updatePetWithVerification(Pet oldPet, Pet updatedPet) {
        JSONObject updatedPetJSON = new JSONObject(updatedPet.getMap());
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(updatedPetJSON.toJSONString())
                .put("/pet");
        Assert.assertEquals("Can't update pet!", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "Pet updated successfully");
        JSONObject newPet = PetResponses.getPetJSON(oldPet.getId());
        Assert.assertEquals("User is incorrect!", updatedPet.getId(), newPet.get("id"));
        Logger.getAnonymousLogger().log(Level.INFO, "Pets are same");
    }

    public JSONObject getPetJSON(long id) {
        verifyPet(id);
        Logger.getAnonymousLogger().log(Level.INFO, "Pet exists");
        JSONParser parser = new JSONParser();
        JSONObject pet = new JSONObject();
        try {
            pet = (JSONObject) parser.parse(getPet(id).getBody().asString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Assert.assertEquals("Pet is incorrect!", id, pet.get("id"));
        Logger.getAnonymousLogger().log(Level.INFO, "Pet is correct");
        return pet;
    }

    public Response getPet(long id) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .get("/pet/" + id);
    }

    public static void deletePet(long id) {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .delete("/pet/" + id);
        Assert.assertEquals("Can't delete pet!", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "Pet deleted successfully");
    }
}
