package rest;

import containers.Order;
import data.StatusCodes;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

@UtilityClass
public class StoreResponses {

    public void getInventory() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .get("/store/inventory");
        Assert.assertEquals("Can't get inventory!", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "Inventory:\n" + response.getBody().asPrettyString());
    }

    public static void placeOrder(Order order) {
        JSONObject orderJSON = new JSONObject(order.getMap());
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(orderJSON.toJSONString())
                .post("/store/order");
        Assert.assertEquals("Order can't be placed!", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "Order was placed!");
    }

    public static void findOrder(long id) {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .get("/store/order/" + id);
        Assert.assertEquals("Order not found!", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "Found order:\n" + response.getBody().asPrettyString());
    }

    public static void deleteOrder(long id) {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .delete("/store/order/" + id);
        Assert.assertEquals("Order not found!", StatusCodes.STATUS_200.getValue(), response.getStatusCode());
        Logger.getAnonymousLogger().log(Level.INFO, "Order has been deleted");
    }
}
