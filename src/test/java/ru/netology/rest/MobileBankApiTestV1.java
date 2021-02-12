package ru.netology.rest;

import org.junit.jupiter.api.Test;
import org.w3c.dom.CDATASection;

import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;


//import static org.hamcrest.Matchers.*;

//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnPostmanGet() {
      // Given - When - Then
      // Предусловия
      given()
          .baseUri("https://postman-echo.com")
      // Выполняемые действия
      .when()
          .get("/get?foo1=bar1&foo2=bar2%27")
      // Проверки
      .then()
          .statusCode(200)
              // .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
      ;
    }

    @Test
    void shouldReturnPostmanEcho() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body(" {\"field1\":\"value\",\"field2\":10}" )
                // Выполняемые действия
                .when()
                  .post("/post")
                // Проверки
                .then()
                .statusCode(404)
                .body("data",equalTo(" {\"field1\":\"value\",\"field2\":10}" ))
         ;
    }

}
