package com.gb.lesson5.homeWork;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;
import java.util.List;

public interface MiniMarketApi {

    @GET("categories/{id}")
    Call<MiniMarketCategoryResult> getCategory(@Path("id") Integer id);

    @GET("products/")
    Call<List<MiniMarketProductsResult>> getProducts();

    @POST("products/")
    Call<MiniMarketProductsResult> createProducts(@Body MiniMarketProductsResult body);

    @PUT("products/")
    Call<MiniMarketProductsResult> modifyProducts(@Body MiniMarketProductsResult body);

//    @GET("products/{id}")
//    Call<MiniMarketProductsResult> getProductsId(@Path("id") Integer id);

//    @DELETE("products/{id}")
//    Call<Void> removeProductsId(@Path("id") Integer id);


//    @GET("products/{id}")
//    Call<MiniMarketCategoryResult> getProductsIdAfterDelete(@Path("id") Integer id);
}


