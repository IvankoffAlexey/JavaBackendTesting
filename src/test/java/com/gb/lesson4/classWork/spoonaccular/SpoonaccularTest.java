package com.gb.lesson4.classWork.spoonaccular;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;

public class SpoonaccularTest extends AbstractTest{

    private static final String API_KEY = "df76289e26bd474e8d8a3c52bc2baf74";

    @BeforeAll
    @Disabled
    static void beforeAll() {

        RestAssured.baseURI = "https://api.spoonacular.com/";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", API_KEY)
                .log(LogDetail.ALL)
                .build();

       RestAssured.responseSpecification = new ResponseSpecBuilder()
               .log(LogDetail.BODY)
               .build();

    }

}
