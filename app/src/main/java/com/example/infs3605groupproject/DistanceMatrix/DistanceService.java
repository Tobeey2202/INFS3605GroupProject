package com.example.infs3605groupproject.DistanceMatrix;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DistanceService {

    @GET("distancematrix/json?=")
    Call<ResultDistance> getDistance(@Query("key") String key, @Query("origins") String origins, @Query("destinations") String destinations);
}
