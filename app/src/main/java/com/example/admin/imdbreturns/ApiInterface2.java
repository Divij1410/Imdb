package com.example.admin.imdbreturns;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ADMIN on 30-Jul-17.
 */
interface ApiInterface2 {

    @GET("3/movie/{key}/videos?api_key=ef77af4df35b3401b44daa473d296b51")
    Call<VideoResponse> getvideos(@Path("key") String key);
}
