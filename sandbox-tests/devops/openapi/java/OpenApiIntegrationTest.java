package com.epam.poc.aicode.devops.openapi;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapi4j.parser.OpenApi3Parser;
import org.openapi4j.parser.validation.v3.OpenApi3Validator;
import org.openapi4j.schema.validator.v3.SchemaValidator;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.net.URL;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OpenApiIntegrationTest {

    @LocalServerPort
    private int port;
    private URL openApiUrl;

    @BeforeEach
    void setUp() throws Exception {
        RestAssured.useRelaxedHTTPSValidation();
        var host = "http://localhost:" + port;
        var oApiUrl = host + "/v3/api-docs";

        this.openApiUrl = new URL(oApiUrl);

        RestAssured.baseURI = host;
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void testOpenApiDocValidation() throws Exception {
        var openAPI = new OpenApi3Parser().parse(openApiUrl, false);
        var validationResults = OpenApi3Validator.instance().validate(openAPI);

        assertTrue(validationResults.isValid());
        assertNotNull(openAPI);

    }

    @Test
    void testOpenApiOperations() throws Exception {
        var openAPI = new OpenApi3Parser().parse(openApiUrl, true);

        openAPI.getPaths().forEach((path, pathItem) -> {
            pathItem.getOperations().forEach(
                (operation, dummy) -> {
                    given()
                        .contentType("application/json")
                        .when()
                        .request(operation, path)
                        .then()
                        .body(matchesJsonSchemaInClasspath("users-schema.json"));
                });
        });
    }

    @Test
    void testOpenApiMatchingToController() throws Exception {
        var contentNode = given()
            .contentType("application/json")
            .when()
            .request("GET", "/api/users")
            .then()
            .extract()
            .response()
            .as(JsonNode.class);

        var schemaNode =
            new OpenApi3Parser().parse(openApiUrl, true).toNode();

        var schemaValidator = new SchemaValidator(null, schemaNode);

        schemaValidator.validate(contentNode);
    }
}
