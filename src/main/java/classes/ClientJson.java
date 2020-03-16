package classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;
import util.CustomerC;

import java.io.IOException;
import java.util.Objects;


public class ClientJson {
    CustomerC customerC = new CustomerC();
   XSSFDoc docAssignment = new XSSFDoc();


    private final OkHttpClient httpClient = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        ClientJson obj = new ClientJson();
        obj.sendPOST();
    }

    public ClientJson() throws IOException {
    }

    private void sendPOST() throws IOException {
        Gson gson = new GsonBuilder().create();

        //Setup the request, passing the "CustomerC" class as parameter
        RequestBody body = RequestBody.create(
                gson.toJson(customerC),
                MediaType.parse("application/json; charset=utf-8")
        );
        // json request body
        Request request = new Request.Builder()
                .url("https://api-dev.smartpos.net.br/api/v1/customer")
                .addHeader("authorization", "NA-AUTH HJwi8Nvh8kaE/4rgvC+z/9t+BF2+XMIV4zue2NgZxA5iPH7hG6r/ovRoDyXSKZ13Ig6t5o3t9O23W6SILOyO1zTMPsCTambB0hxXuZjMOVbgzQ4zcLPxuc6X7dQnf/c3mt+tE0aomUkSQG8W756hGjBwzMkRi9nuWiUc/JZr4PpAchNFwjtGqspaGqPc2XQZ")
                .addHeader("content-type", "application/json")
                .post(body)
                .build();
        //The response
       try (Response response = httpClient.newCall(request).execute()){

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response + customerC.toString());
            // Get response body
            System.out.println(Objects.requireNonNull(response.body()).string());
        }


    }
}

