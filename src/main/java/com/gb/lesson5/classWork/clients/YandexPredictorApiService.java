package com.gb.lesson5.classWork.clients;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.List;

import static com.gb.lesson5.classWork.clients.RetrofitCallExecutor.executeCall;

public class YandexPredictorApiService {

private static final String API_KEY = "pdct.1.1.20220605T195056Z.6eece3352e074c9d.c8cf74b9afd716f89a17681745fd6aa0c50ff1f7\n";
private final  YandexPredictorApi api;
    public YandexPredictorApiService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(System.out::println);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        api = new Retrofit.Builder()
                .baseUrl("https://predictor.yandex.net/api/v1/predict.json/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(YandexPredictorApi.class);
    }

    public List<String> getLangs() {
       Call<List<String>> call = api.getLangs(API_KEY);
        return executeCall(call);
    }

    public YandexPredictorResult complete(String query, String lang, Integer limit) {
        return executeCall(api.complete(API_KEY, query, lang, limit));
    }
}
