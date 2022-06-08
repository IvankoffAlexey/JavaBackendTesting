package com.gb.lesson5.classWork;

import com.gb.lesson5.classWork.clients.YandexPredictorApiService;
import com.gb.lesson5.classWork.clients.YandexPredictorResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class YandexPredictorApiTest extends AbstractYandexPredictorApiTest {

    private static YandexPredictorApiService service;

    @BeforeAll
    static void beforeAll() {
        service = new YandexPredictorApiService();
    }

    @Test
    void testGetLangs() throws IOException {
        List<String> langs = service.getLangs();
        assertJson(getResource("langs.json"), langs);
    }

    @Test
    void testPrediction() throws IOException {
        YandexPredictorResult result = service.complete("Hello-wo", "en", 3);
        assertJson(getResource("complete.json"), result);
    }
}
