package com.rocketsoftware.product.service;



import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class AccessService {

    private String accessToken;

    public void retrieveAccessToken(final String clientID, String clientSecret, final String audience, String domain) {


        try {
            HttpResponse<JsonNode> response = Unirest.post(domain)
                    .header("content-type", "application/json")
                    .body("{" +
                            "\"client_id\":\"" + clientID + "\"," +
                            "\"client_secret\":\"" + clientSecret + "\"," +
                            "\"audience\":\"" + audience + "\"," +
                            "\"grant_type\":\"client_credentials\"}")
                    .asJson();
            accessToken = response.getBody().getObject().getString("access_token");

        } catch (UnirestException e) {
            throw new RuntimeException("Unable to retrieve the access token" + e);
        }

    }

    public String getAccessToken() {
        return accessToken;
    }


}
