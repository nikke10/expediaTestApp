package com.expedia.testapp.repository.remote.api;


import com.expedia.testapp.repository.models.response.SearchActivitiesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchAPI {

    @GET("search")
    Call<SearchActivitiesResponse> getActivities(@Query("location") String location, @Query("startDate") String startDate, @Query("endDate") String endDate);
}
