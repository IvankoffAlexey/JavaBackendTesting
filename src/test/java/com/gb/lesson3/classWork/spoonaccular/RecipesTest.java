package com.gb.lesson3.classWork.spoonaccular;

import com.gb.lesson3.classWork.EquipmentItem;
import com.gb.lesson3.classWork.EquipmentResponce;
import io.restassured.RestAssured;
import net.javacrumbs.jsonunit.JsonAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.*;

public class RecipesTest {

    private static final String API_KEY = "df76289e26bd474e8d8a3c52bc2baf74";

    @BeforeAll
    @Disabled
    static void beforeAll() {
        RestAssured.baseURI = "https://api.spoonacular.com/recipes/";
    }

    @Test
    @Disabled
    void testAutocompleteSearch() throws IOException {

        String actually = given()
                .log()
                .all()
                .param("apiKey", API_KEY)
                .param("query", "cheese")
                .param("number", 10)
                .expect()
                .log()
                .body()
                .when()
                .get("autocomplete")
                .body()
                .prettyPrint();

        String expected = getResourceAsString("testAutocompleteSearch/expected.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );
    }

    public String getResourceAsString(String resource) throws IOException {
        InputStream stream = getClass().getResourceAsStream(resource);
        assert stream != null;
        byte[] bytes = stream.readAllBytes();
        return new String(bytes, StandardCharsets.UTF_8);
    }


    @Test
    @Disabled
    void testTasteRecipeById() {
        given()
                .log()
                .all()
                .param("apiKey", API_KEY)
                .pathParam("id", 69095)
                .expect()
                .log()
                .body()
                .body("sweetness", is(48.15F))
                .body("saltiness", is(45.29F))
                .body("sourness", is(15.6F))
                .body("bitterness", is(19.17F))
                .body("savoriness", is(26.45F))
                .body("fattiness", is(100.0F))
                .body("spiciness", is(0.0F))
                .when()
                .get("{id}/tasteWidget.json");
    }

    @Test
    @Disabled
    void testEquipmentById() {

        EquipmentItem target = new EquipmentItem("pie-pan.png", "pie form");

        EquipmentResponce.EquipmentResponse response = given()
                .param("apiKey", API_KEY)
                .pathParam("id", 1003464)
                .expect()
                .when()
                .get("{id}/equipmentWidget.json")
                .as(EquipmentResponce.EquipmentResponse.class);

        response.getEquipment()
                .stream()
                .filter(item -> item.getName().equals("pie form"))
                .peek(item -> Assertions.assertEquals(target, item))
                .findAny()
                .orElseThrow();
    }


}