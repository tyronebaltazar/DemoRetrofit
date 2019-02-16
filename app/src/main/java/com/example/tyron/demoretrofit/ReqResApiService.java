package com.example.tyron.demoretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tyron on 15/02/2019.
 */

public interface ReqResApiService {

    @GET("users")
    Call<pageResponse> getUserPage(@Query("page") String id);


}
