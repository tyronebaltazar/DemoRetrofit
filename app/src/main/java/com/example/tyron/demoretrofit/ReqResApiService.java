package com.example.tyron.demoretrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tyron on 15/02/2019.
 */

public interface ReqResApiService {

    @GET("users")
    Observable<pageResponse> getUserPage(@Query("page") String id);


}
