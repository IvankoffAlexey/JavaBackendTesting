package com.gb.lesson5.classWork.clients;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface YandexPredictorApi {

    @GET("getLangs")
    Call<List<String>> getLangs(@Query("key") String key);

    @POST("complete")
    Call<YandexPredictorResult> complete(
            @Query("key") String key,
            @Query("q") String q,
            @Query("lang")String lang,
            @Query("limit") Integer limit
        );
}
