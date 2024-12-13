package com.epam.aicode.springpr;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.epam.aicode.springpr.rest.ItemResource;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JacksonDeserializationTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = this.port;
    }

    @Test
    void test_postValidItem() {
        Response response = given().contentType(ContentType.JSON).body("{\"name\":\"nameX1\"}").when()
                .post(ItemResource.BASE_URI).then().log().all().extract().response();
        assertThat(response.statusCode()).isEqualTo(201);
    }

    @Test
    void test_postInvalidItem() {
        Response response = given().contentType(ContentType.JSON).body("{\"name1\":\"nameX2\"}").when()
                .post(ItemResource.BASE_URI).then().log().all().extract().response();
        assertThat(response.statusCode()).isEqualTo(400);
    }
}
