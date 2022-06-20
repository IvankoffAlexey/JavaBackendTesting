package com.gb.lesson5.homeWork;

import org.junit.jupiter.api.*;
import retrofit2.Response;
import java.io.IOException;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class MiniMarketApiTest extends AbstractMiniMarketApiTest {

    private static MiniMarketApiService service;

    @BeforeAll
    static void beforeAll() {
        service = new MiniMarketApiService();
    }

    private static Long id;

    @Test
    @Order(1)
    void testGetCategory() throws IOException {
        MiniMarketCategoryResult category = service.getCategory(2);
//         Перед проведением сравнения необходимо обновить .json файл
//        assertJson(getResource("category.json"), category);
    }

    @Test
    @Order(2)
    void testGetProducts()  {
        List<MiniMarketProductsResult> products = service.getProducts();
//                 Перед проведением тестов на сравнения необходимо обновить .json файл
//        assertJson(getResource("products.json"), products);

    }


    @Test
    @Order(3)
    void testCreateProducts() throws IOException {
        MiniMarketProductsResult product = new MiniMarketProductsResult();
        product.setId(null);
        product.setTitle("Bred");
        product.setPrice(100);
        product.setCategoryTitle("Food");
        Response<MiniMarketProductsResult> response = service.createProducts(product);
        MiniMarketProductsResult created = response.body();

        Assertions.assertEquals(201, response.code());
        Assertions.assertNotNull(created);
        id = created.getId();
        System.out.println(id);
    }

    @Test
    @Order(4)
    void testGetProductsId() throws IOException {
        MiniMarketProductsResult product = service.getProductsId(id);
        System.out.println(id + " " + product.getTitle() + " " + product.getPrice());
    }

    @Test
    @Order(5)
    void testUpdateProducts() throws IOException {
        MiniMarketProductsResult product = new MiniMarketProductsResult();
        product.setId(id);
        product.setTitle("BredIsBeer");
        product.setPrice(101);
        product.setCategoryTitle("Food");
        Response<MiniMarketProductsResult> response = service.updateProducts(product);
        MiniMarketProductsResult update = response.body();

        Assertions.assertEquals(200, response.code());
        Assertions.assertNotNull(update);
        System.out.println("Id :" + id + " - Изменен!");

    }

    @Test
    @Order(6)
    void testGetProductsIdAfterUpdate() throws IOException {
        MiniMarketProductsResult product = service.getProductsId(id);
        System.out.println(id + " " + product.getTitle() + " " + product.getPrice());
    }
    @Test
    @Order(7)
    void testDeleteProducts() throws IOException {
        Response<Void> remove = service.deleteProductsId(id);
        Assertions.assertEquals(200, remove.code());
        System.out.println("ID" + " : " + id + " - " + "Удален");
//               Перед проведением тестов на сравнения необходимо обновить .json файл
//        assertJson(getResource("productId.json"), delete);
    }

    @Test
    @Order(8)
    void testGetProductsIdAfterDelete() throws IOException {
        MiniMarketProductsResult product = service.getProductsId(id);
        System.out.println("Id : " + id + " - " + " Не найден " );
    }
}
