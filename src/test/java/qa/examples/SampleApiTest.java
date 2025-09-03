package qa.examples;

import qa.base.ApiBaseTest;
import qa.base.api.BaseApiClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import io.qameta.allure.Description;
import static org.assertj.core.api.Assertions.assertThat;

public class SampleApiTest extends ApiBaseTest {

    @Test
    @DisplayName("JSONPlaceholder API Testi")
    @Description("JSONPlaceholder API'den kullanıcı listesi alır")
    void getUsersTest() {
        // JSONPlaceholder için özel client
        Response response = RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .contentType("application/json")
                .when()
                .get("/users");

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getList("$")).isNotEmpty();
        assertThat(response.jsonPath().getList("$").size()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Base API Client Kullanım Örneği")
    @Description("BaseApiClient sınıfının nasıl extend edilebileceğini gösterir")
    void baseApiClientExampleTest() {
        // Kendi API client'ınızı böyle oluşturabilirsiniz
        JsonPlaceholderApiClient apiClient = new JsonPlaceholderApiClient();
        Response response = apiClient.getUsers();

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getList("$")).isNotEmpty();
    }

    // BaseApiClient'ı extend eden örnek sınıf
    private static class JsonPlaceholderApiClient extends BaseApiClient {

        public JsonPlaceholderApiClient() {
            super();
            // Base URL'i override et
            this.requestSpec = RestAssured.given()
                    .baseUri("https://jsonplaceholder.typicode.com")
                    .contentType("application/json")
                    .accept("application/json");
        }

        public Response getUsers() {
            return get("/users");
        }

        public Response getUser(int userId) {
            return get("/users/" + userId);
        }

        public Response createUser(Object user) {
            return post("/users", user);
        }
    }
}