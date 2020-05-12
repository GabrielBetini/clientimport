package classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;
import util.CustomerC;

import java.io.IOException;
import java.util.Objects;


public class ClientJson {
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

        for (CustomerC customerC : docAssignment.customerList) {

            //Setup the request, passing the "CustomerC" class as parameter
            RequestBody body = RequestBody.create(
                    gson.toJson(customerC),
                    MediaType.parse("application/json; charset=utf-8")
            );
            // json request body
            Request request = new Request.Builder()
                    .url("http://localhost:8080/api/v1/customer")
                    .addHeader("Authorization", "NA-AUTH HJwi8Nvh8kaE/4rgvC+z/9t+BF2+XMIV4zue2NgZxA6PiqxqsguoBeeAX4XqWd7vEf4YPYAvo2xkOFE9swMKruvhN5xVTPtE+wqQZueXuy89IHXEhC4DS1nnH3O+fGuV6wAzco7TzBKkgNBlQUCrJL8rax4uqzY83mFNVymxd2Pr4TecVUz7RPsKkGbnl7sv8etzcWCOpyHCONQYo0bWFusAM3KO08wSpIDQZUFAqySpUuERIb4NQbEly3YXWKBS")
                    .addHeader("Content-Type", "application/json")
                    .post(body)
                    .build();
            //The response
            try (Response response = httpClient.newCall(request).execute()) {

                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response + customerC.toString());
                }
                // Get response body
                System.out.println(Objects.requireNonNull(response.body()).string());
            }

        }
    }
}
