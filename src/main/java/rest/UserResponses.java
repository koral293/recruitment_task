package rest;

import containers.User;
import data.StatusCodes;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@UtilityClass
public class UserResponses {

    public void loginWithUser(User user) {
        JSONObject login = new JSONObject(user.getMap());
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(login.toJSONString())
                .get("/user/login");
        Assert.assertEquals("Can't loing with provided user!", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "User logged successful");
    }

    public JSONObject getUserJSON(String username) {
        verifyUser(username);
        Logger.getAnonymousLogger().log(Level.INFO, "User exists");
        JSONParser parser = new JSONParser();
        JSONObject user = new JSONObject();
        try {
            user = (JSONObject) parser.parse(getUser(username).getBody().asString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Assert.assertEquals("User is incorrect!", username, user.get("username"));
        Logger.getAnonymousLogger().log(Level.INFO, "User is correct");
        return user;
    }

    public void createNewUser(User user) {
        JSONObject newUser = new JSONObject(user.getMap());
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(String.format("[\n%s]\n", newUser.toJSONString()))
                .post("/user/createWithList");
        Assert.assertEquals("Can't create user!", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "User created successfully");
    }

    public void updateUserWithVerification(User oldUser, User updatedUser) {
        JSONObject updatedUserJSON = new JSONObject(updatedUser.getMap());
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(updatedUserJSON.toJSONString())
                .put("/user/" + oldUser.getUsername());
        Assert.assertEquals("Wrong status received!", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "User updated successfully");
        JSONObject newUser = UserResponses.getUserJSON(oldUser.getUsername());
        Assert.assertEquals("User is incorrect!", updatedUser.getUsername(), newUser.get("username"));
        Logger.getAnonymousLogger().log(Level.INFO, "Users are same");
    }

    public void deleteUser(User user) {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .delete("/user/" + user.getUsername());
        Assert.assertEquals("Can't delete user!", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "User deleted successfully");
    }

    public void verifyUser(String username) {
        Response response = getUser(username);
        Assert.assertEquals("Can't get user!", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "User exists");
    }

    private Response getUser(String username) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .get("/user/" + username);
    }

    public void verifyDeletedUser(String username) {
        Response response = getUser(username);
        Assert.assertEquals("User not deleted properly", StatusCodes.STATUS_404.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "User deleted properly");
    }

    public void creatListOfUsers(List<User> users) {
        JSONArray array = new JSONArray();
        for (User user : users) {
            JSONObject jsonUser = new JSONObject(user.getMap());
            array.add(jsonUser);
        }
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(array.toJSONString())
                .post("/user/createWithList");
        Assert.assertEquals("Users created successfully", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "Users created successfully");
    }

}
