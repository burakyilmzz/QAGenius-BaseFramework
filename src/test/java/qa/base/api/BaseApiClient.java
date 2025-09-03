package qa.base.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import qa.base.config.ConfigManager;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseApiClient {
    protected RequestSpecification requestSpec;
    protected ObjectMapper objectMapper;

    public BaseApiClient() {
        String baseUrl = ConfigManager.getProperty("api.base.url", "http://localhost:8080");

        this.requestSpec = RestAssured.given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .accept("application/json");

        this.objectMapper = new ObjectMapper();
    }

    protected Response get(String endpoint) {
        return requestSpec.when().get(endpoint);
    }

    protected Response post(String endpoint, Object body) {
        return requestSpec.body(body).when().post(endpoint);
    }

    protected Response put(String endpoint, Object body) {
        return requestSpec.body(body).when().put(endpoint);
    }

    protected Response delete(String endpoint) {
        return requestSpec.when().delete(endpoint);
    }

    protected Response patch(String endpoint, Object body) {
        return requestSpec.body(body).when().patch(endpoint);
    }

    public BaseApiClient withHeader(String name, String value) {
        requestSpec.header(name, value);
        return this;
    }

    public BaseApiClient withAuth(String token) {
        requestSpec.header("Authorization", "Bearer " + token);
        return this;
    }


}