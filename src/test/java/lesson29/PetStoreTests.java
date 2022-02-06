package lesson29;

import okhttp3.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class PetStoreTests {

    public JSONObject jsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("petId", 0);
        jsonObject.put("quantity", 0);
        jsonObject.put("shipDate", "2022-02-06T12:28:28.272Z");
        jsonObject.put("status", "placed");
        jsonObject.put("complete", true);
        return jsonObject;
    }


    //POST /store/order
    @Test(priority = 10)
    public void successOrderCreation() throws IOException {
        JSONObject jsonObject = jsonObject();

        RestClient restClient = new RestClient();
        Response response = restClient.postOrder(jsonObject);
        Assert.assertEquals(response.code(), 200, "FAIL: Status code is wrong");
    }


    //GET /store/order/{orderId}
    @Test(priority = 20)
    public void successGetOrder() throws IOException {
        JSONObject expectedJson = jsonObject();
        expectedJson.put("shipDate", "2022-02-06T12:28:28.272+0000");

        RestClient restClient = new RestClient();
        Response response = restClient.getValidOrder(1);

        JSONObject actualJson = new JSONObject(response.body().string());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.code(), 200, "Status code is wrong");
        softAssert.assertEquals(actualJson.toString(), expectedJson.toString(), "Response is not equal to expected json");

        softAssert.assertAll();
    }

    @Test(priority = 21)
    public void failedGetOrder() throws IOException {
        JSONObject expectedErrorJson = new JSONObject();
        expectedErrorJson.put("code", 1);
        expectedErrorJson.put("type", "error");
        expectedErrorJson.put("message", "Order not found");

        RestClient restClient = new RestClient();
        Response response = restClient.getInvalidOrder(11);

        JSONObject actualJson = new JSONObject(response.body().string());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.code(), 404, "Status code is wrong");
        softAssert.assertEquals(actualJson.toString(), expectedErrorJson.toString(), "Response is not equal to expected json");
        softAssert.assertAll();
    }


    //DELETE /store/order/{orderId}
    @Test(priority = 30)
    public void successOrderDeletion() throws IOException {
        JSONObject creationJson = jsonObject();

        RestClient restClient = new RestClient();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(restClient.postOrder(creationJson).code(), 200, "FAIL: Order not created");

        Response deletionResponse = restClient.deleteValidOrder(1);
        softAssert.assertEquals(deletionResponse.code(), 200, "FAIL: Status code is wrong");
        softAssert.assertAll();
    }

    @Test(priority = 31)
    public void deleteOrderInvalidId() throws IOException {
        RestClient restClient = new RestClient();
        Response deletionResponse = restClient.deleteOrderInvalidId();
        Assert.assertEquals(deletionResponse.code(), 404, "Status code is wrong");
    }


    //GET /store/inventory
    @Test(priority = 40)
    public void getStoreInventory() throws IOException {
        RestClient restClient = new RestClient();
        Response response = restClient.storeInventory();
        Assert.assertEquals((response.code()), 200, "Status code is wrong");
    }
}
