package com.gb.lesson4.homeWork.spoonaccular.shoppingListTest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class ShoppingListTest extends ShoppingListSpecificationTest {

    private static final String hash = "5475f78358abb41d4f19c9c7fec7c3562968a38f";
    private static final String username = "qatesta2";
    private static final String date = "2022-05-23";
    private static final String startDate = "2022-05-22";
    private static final String endDate = "2022-05-24";

    private static String id;

    @Test
    @DisplayName("Add Shopping List")
    void addShoppingList() throws Exception {
        String requestBody = getResource("addShoppingList.json");
        id = given()
                .contentType(ContentType.JSON)
                .queryParam("hash", hash)
                .pathParam("username", username)
                .body(requestBody)
                .when()
                .post("{username}/shopping-list/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();
    }

    @Test
    @DisplayName("Get Shopping List Test")
    void getShoppingListTest() throws Exception {

        given()
                .queryParam("hash", hash)
                .pathParam("username", username)
                .expect()
                .when()
                .get("/{username}/shopping-list")
                .then()
                .statusCode(200);

    }

    @Test()
    @DisplayName("Remove Coffee From Meal Plan")
    void removeCoffeeFromMealPlanTest() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("hash", hash)
                .pathParam("username", username)
                .when()
                .delete("{username}/shopping-list/items/" + id)
                .then()
                .body(containsString("success"))
                .statusCode(200);
    }
}
