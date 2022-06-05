package com.gb.lesson4.classWork.spoonaccular;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class ImageClassifyTest extends SpoonaccularTest {
    @Test
    void testBurgerClassification() {
        given()
                .multiPart(getFile("burger.jpg"))
                .expect().log().body()
                .body("status", is("success"))
                .body("category", is("burger"))
                .body("probability", greaterThan(0.7F))
                .when()
                .post("food/images/classify");
    }
}
