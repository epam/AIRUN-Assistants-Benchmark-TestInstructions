package com.epam.aicode.springpr;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

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
public class ItemResourceTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = this.port;
    }

    // GET is tested within PUT and DELETE

    @Test
    void test_postItem() {
        Response response = given().contentType(ContentType.JSON).body("{\"name\":\"nameXpost1\"}").when()
                .post(ItemResource.BASE_URI).then().log().all().extract().response();
        assertThat(response.statusCode()).isEqualTo(201);
        ItemDTO item = response.as(ItemDTO.class);
        assertThat(item).isNotNull();
        assertThat(item.getId()).isNotNull();
        assertThat(item.getName()).isEqualTo("nameXpost1");
    }

    @Test
    void test_putItem() {
        // prepare
        Response response = given().contentType(ContentType.JSON).body("{\"name\":\"nameXput1\"}").when()
                .post(ItemResource.BASE_URI).then().extract().response();
        assertThat(response.statusCode()).isEqualTo(201);
        ItemDTO item = response.as(ItemDTO.class);
        Long id = item.getId();

        // test PUT
        String name = "nameXput1updated";
        item.setName(name);
        response = given().pathParam("id", id).contentType(ContentType.JSON).body(item).when()
                .put(ItemResource.BASE_URI + "/{id}").then().log().all().extract().response();
        assertThat(response.statusCode()).isEqualTo(200);

        response = given().pathParam("id", id).when().get(ItemResource.BASE_URI + "/{id}").then().log().all().extract()
                .response();
        assertThat(response.statusCode()).isEqualTo(200);
        ItemDTO updatedItem = response.as(ItemDTO.class);
        assertThat(updatedItem).isNotNull();
        assertThat(updatedItem).isEqualTo(item);
    }

    @Test
    void test_deleteItem() {
        // prepare
        Response response = given().contentType(ContentType.JSON).body("{\"name\":\"nameXdelete1\"}").when()
                .post(ItemResource.BASE_URI).then().extract().response();
        assertThat(response.statusCode()).isEqualTo(201);
        ItemDTO item = response.as(ItemDTO.class);
        Long id = item.getId();

        // test DELETE
        response = given().pathParam("id", id).when().delete(ItemResource.BASE_URI + "/{id}").then().log().all()
                .extract().response();
        assertThat(response.statusCode()).isEqualTo(204);

        response = given().pathParam("id", id).when().get(ItemResource.BASE_URI + "/{id}").then().log().all().extract()
                .response();
        assertThat(response.statusCode()).isEqualTo(404);
    }
}
