package lesson29;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RestClient {

    public Response postOrder(JSONObject jsonObject) throws IOException {
        RequestBody body = RequestBody.create(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .post(body)
                .url("https://petstore.swagger.io/v2/store/order")
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = new OkHttpClient();
        return client.newCall(request).execute();
    }

    public Response getValidOrder(int id) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://petstore.swagger.io/v2/store/order/" + id)
                .build();
        OkHttpClient client = new OkHttpClient();
        return client.newCall(request).execute();
    }

    public Response getInvalidOrder(int id) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://petstore.swagger.io/v2/store/order/" + id)
                .build();
        OkHttpClient client = new OkHttpClient();
        return client.newCall(request).execute();
    }

    public Response deleteValidOrder(int id) throws IOException {
        Request requestDelete = new Request.Builder()
                .delete()
                .url("https://petstore.swagger.io/v2/store/order/" + id)
                .build();
        OkHttpClient client = new OkHttpClient();
        return client.newCall(requestDelete).execute();
    }

    public Response deleteOrderInvalidId() throws IOException {
        Request request = new Request.Builder()
                .delete()
                .url("https://petstore.swagger.io/v2/store/order/1.1")
                .build();
        OkHttpClient client = new OkHttpClient();
        return client.newCall(request).execute();
    }

    public Response storeInventory() throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://petstore.swagger.io/v2/store/inventory")
                .build();
        OkHttpClient client = new OkHttpClient();
        return client.newCall(request).execute();
    }
}