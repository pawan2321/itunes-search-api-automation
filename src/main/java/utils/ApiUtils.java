package utils;

import endpoints.Endpoints;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiUtils {
    public static Response search(String term) {
        return given()
                .param("term", term)
                .when()
                .get(Endpoints.SEARCH);
    }

    public static Response searchWithParams(String term, String media, String country, int limit) {
        return given()
                .param("term", term)
                .param("media", media)
                .param("country", country)
                .param("limit", limit)
                .when()
                .get(Endpoints.SEARCH);
    }
}
