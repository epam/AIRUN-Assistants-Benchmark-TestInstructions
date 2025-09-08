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

    private static final String TEST_ITEM_NAME = "testItem";
    private static final String UPDATED_ITEM_NAME = "updatedTestItem";

    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = this.port;
    }

    @Test
    void test_getItem_success() {
        Response createResponse = given()
            .contentType(ContentType.JSON)
            .body("{\"name\":\"" + TEST_ITEM_NAME + "\"}")
            .when()
            .post(ItemResource.BASE_URI)
            .then()
            .extract()
            .response();
        assertThat(createResponse.statusCode()).isEqualTo(201);
        ItemDTO createdItem = createResponse.as(ItemDTO.class);

        Response getResponse = given()
            .pathParam("id", createdItem.getId())
            .when()
            .get(ItemResource.BASE_URI + "/{id}")
            .then()
            .log().all()
            .extract()
            .response();

        assertThat(getResponse.statusCode()).isEqualTo(200);
        ItemDTO retrievedItem = getResponse.as(ItemDTO.class);
        assertThat(retrievedItem).isNotNull();
        assertThat(retrievedItem.getId()).isEqualTo(createdItem.getId());
        assertThat(retrievedItem.getName()).isEqualTo(TEST_ITEM_NAME);
    }

    @Test
    void test_getItem_notFound() {
        Long nonExistentId = 99999L;
        Response response = given()
            .pathParam("id", nonExistentId)
            .when()
            .get(ItemResource.BASE_URI + "/{id}")
            .then()
            .log().all()
            .extract()
            .response();

        assertThat(response.statusCode()).isEqualTo(404);
    }

    @Test
    void test_postItem() {
        Response response = given()
            .contentType(ContentType.JSON)
            .body("{\"name\":\"" + TEST_ITEM_NAME + "\"}")
            .when()
            .post(ItemResource.BASE_URI)
            .then()
            .log().all()
            .extract()
            .response();

        assertThat(response.statusCode()).isEqualTo(201);
        ItemDTO item = response.as(ItemDTO.class);
        assertThat(item).isNotNull();
        assertThat(item.getId()).isNotNull();
        assertThat(item.getName()).isEqualTo(TEST_ITEM_NAME);
    }

    @Test
    void test_putItem() {
        Response response = given()
            .contentType(ContentType.JSON)
            .body("{\"name\":\"" + TEST_ITEM_NAME + "\"}")
            .when()
            .post(ItemResource.BASE_URI)
            .then()
            .extract()
            .response();

        assertThat(response.statusCode()).isEqualTo(201);
        ItemDTO item = response.as(ItemDTO.class);
        Long id = item.getId();

        item.setName(UPDATED_ITEM_NAME);
        response = given()
            .pathParam("id", id)
            .contentType(ContentType.JSON)
            .body(item)
            .when()
            .put(ItemResource.BASE_URI + "/{id}")
            .then()
            .log().all()
            .extract()
            .response();

        assertThat(response.statusCode()).isEqualTo(200);

        response = given()
            .pathParam("id", id)
            .when()
            .get(ItemResource.BASE_URI + "/{id}")
            .then()
            .log().all()
            .extract()
            .response();

        assertThat(response.statusCode()).isEqualTo(200);
        ItemDTO updatedItem = response.as(ItemDTO.class);
        assertThat(updatedItem).isNotNull();
        assertThat(updatedItem.getName()).isEqualTo(UPDATED_ITEM_NAME);
    }

    @Test
    void test_deleteItem() {
        Response response = given()
            .contentType(ContentType.JSON)
            .body("{\"name\":\"" + TEST_ITEM_NAME + "\"}")
            .when()
            .post(ItemResource.BASE_URI)
            .then()
            .extract()
            .response();

        assertThat(response.statusCode()).isEqualTo(201);
        ItemDTO item = response.as(ItemDTO.class);
        Long id = item.getId();

        response = given()
            .pathParam("id", id)
            .when()
            .delete(ItemResource.BASE_URI + "/{id}")
            .then()
            .log().all()
            .extract()
            .response();

        assertThat(response.statusCode()).isEqualTo(204);

        response = given()
            .pathParam("id", id)
            .when()
            .get(ItemResource.BASE_URI + "/{id}")
            .then()
            .log().all()
            .extract()
            .response();

        assertThat(response.statusCode()).isEqualTo(404);
    }
}
