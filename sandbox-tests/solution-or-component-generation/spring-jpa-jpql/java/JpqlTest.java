package com.epam.aicode.springpr;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.epam.aicode.springpr.model.ItemDTO;
import com.epam.aicode.springpr.rest.ItemResource;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JpqlTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = this.port;
    }

    @Test
    void test_getExpiredItems() {
        // prepare
        Response response = given().contentType(ContentType.JSON).body("{\"name\":\"nameX1\"}").when()
                .post(ItemResource.BASE_URI).then().extract().response();
        assertThat(response.statusCode()).isEqualTo(201);

        response = given().contentType(ContentType.JSON)
                .body("{\"name\":\"nameX2\",\"expiredAfter\":\"2023-03-25T00:00:00\"}").when()
                .post(ItemResource.BASE_URI).then().extract().response();
        assertThat(response.statusCode()).isEqualTo(201);
        ItemDTO item = response.as(ItemDTO.class);

        // test
        response = given().when().get(ItemResource.BASE_URI + "/:expired").then().log().all().extract().response();
        assertThat(response.statusCode()).isEqualTo(200);
        List<ItemDTO> expiredItems = response.jsonPath().getList(".", ItemDTO.class);
        assertThat(expiredItems).isEqualTo(List.of(item));
    }
}
