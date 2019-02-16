package com.example.tyron.demoretrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tyron on 15/02/2019.
 */

public class ReqResApiAdapter {

    public static ReqResApiService API_SERVICE;

    public static ReqResApiService getApiService(){

        // Creating the receptor, and setting the log level
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // Add logging as last interceptor
        httpClient.addInterceptor(logging); // <-- this is important line!

        String baseUrl = "https://reqres.in/api/";

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                                            .baseUrl(baseUrl)
                                            .addConverterFactory(GsonConverterFactory.create())
                                            .client(httpClient.build())
                                            .build();
            API_SERVICE = retrofit.create(ReqResApiService.class);
        }
        return API_SERVICE;
    }


}
