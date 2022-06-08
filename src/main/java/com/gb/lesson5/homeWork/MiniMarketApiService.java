package com.gb.lesson5.homeWork;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static com.gb.lesson5.homeWork.CallExecutor.executeCall;

public class MiniMarketApiService {

private final MiniMarketApi api;
    public MiniMarketApiService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(System.out::println);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        api = new Retrofit.Builder()
                .baseUrl("https://minimarket1.herokuapp.com/market/api/v1/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MiniMarketApi.class);
    }

    public MiniMarketCategoryResult getCategory(Integer id) {
       return executeCall(api.getCategory(id));
    }

    public List<MiniMarketProductsResult> getProducts() {
        Call<List<MiniMarketProductsResult>> call = api.getProducts();
        return executeCall(call);
    }

    public Response<MiniMarketProductsResult> createProducts(MiniMarketProductsResult id) throws IOException {
        Call <MiniMarketProductsResult> call = api.createProducts(id);
        return call.execute();
    }

    public Response<MiniMarketProductsResult> modifyProducts(MiniMarketProductsResult body) throws IOException {
        Call <MiniMarketProductsResult> call = api.modifyProducts(body);
        return call.execute();
    }

//    public MiniMarketProductsResult getProductsId(Integer id) {
//        Call<MiniMarketProductsResult> call = api.getProductsId(id);
//        return executeCall(api.getProductsId(call));
//    }

//    public Response<Void> removeProductsId(Integer id) throws IOException {
//        Call<Void> call = api. removeProductsId(id);
//        return call.execute();
//    }

//    public MiniMarketCategoryResult getProductsIdAfterDelete(Integer id) {
//        return executeCall(api.getProductsIdAfterDelete(id));
//    }

}

