package com.gb.lesson5.homeWork;

import org.junit.jupiter.api.*;
import retrofit2.Response;
import java.io.IOException;
import java.util.List;

public class MiniMarketApiTest extends AbstractMiniMarketApiTest {

    private static MiniMarketApiService service;

    @BeforeAll
    static void beforeAll() {
        service = new MiniMarketApiService();
    }

    @BeforeEach
    public void CreateProducts() throws IOException {
        MiniMarketProductsResult product = new MiniMarketProductsResult();
        product.setId(null);
        product.setTitle("Bred");
        product.setPrice(100);
        product.setCategoryTitle("Food");
        Response<MiniMarketProductsResult> response = service.createProducts(product);
        MiniMarketProductsResult created = response.body();

        Assertions.assertEquals(201, response.code());
        Assertions.assertNotNull(created);
        setId(created.getId());
        System.out.println(id);
    }

    int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Test
    void testGetCategory() throws IOException {
        MiniMarketCategoryResult category = service.getCategory(2);
//         Перед проведением сравнения необходимо обновить .json файл
//        assertJson(getResource("category.json"), category);
    }

    @Test
    void testGetProducts()  {
        List<MiniMarketProductsResult> products = service.getProducts();
        //         Перед проведением тестов на сравнения необходимо обновить .json файл
//        assertJson(getResource("products.json"), products);

    }


    @Test
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
        setId(created.getId());
        System.out.println(id);
    }

    @Test
    void testModifyProducts() throws IOException {
        MiniMarketProductsResult product1 = new MiniMarketProductsResult();
        product1.setId(id);
        product1.setTitle("BredIsBeer");
        product1.setPrice(101);
        product1.setCategoryTitle("Food");
        Response<MiniMarketProductsResult> response = service.modifyProducts(product1);
        MiniMarketProductsResult modified = response.body();

        Assertions.assertEquals(200, response.code());
        Assertions.assertNotNull(modified);

    }
//    @Test
//    void testRemoveProducts() throws IOException {
//        Response<Void> remove = service.removeProductsId(id);
//        Assertions.assertEquals(200, remove.body());
//               Перед проведением тестов на сравнения необходимо обновить .json файл
////        assertJson(getResource("productId.json"), delete);
//    }
//    @Test
//    void testProductsIdAfterModify() throws IOException {
//        List<MiniMarketProductsResult> productsIdAfterModify = service.getProductsIdAfterModify(id);
//        //         Перед проведением сравнения необходимо обновить .json файл
//      assertJson(getResource("afterModify.json"), afterModify);
//    }

//    @Test
//    void testRemoveProducts() throws IOException {
//        Response<MiniMarketProductsResult> remove = service.removeProductsId(id);
//        Assertions.assertEquals(200, remove.body());
////        assertJson(getResource("productId.json"), delete);
//    }
////
//    @Test
//    void testProductsIdAfterDelete() {
//        @Nullable MiniMarketCategoryResult afterDelete = service.getProductsIdAfterDelete(id);
////      assertJson(getResource("productIdAfterDelete.json"), afterDelete);
//        }
}
