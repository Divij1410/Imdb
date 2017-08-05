package com.example.admin.imdbreturns;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ADMIN on 29-Jul-17.
 */

interface ApiInterface1 {
    @GET("3/movie/top_rated?api_key=ef77af4df35b3401b44daa473d296b51")
    Call<MoviedataResponse> getTopmovies();
}
