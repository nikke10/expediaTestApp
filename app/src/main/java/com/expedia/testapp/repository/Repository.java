package com.expedia.testapp.repository;

import android.content.Context;

import com.expedia.testapp.repository.models.response.SearchActivitiesResponse;
import com.expedia.testapp.repository.remote.api.SearchAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository implements Callback<SearchActivitiesResponse> {
    Context context;
    ListCallback callback;
    Gson gson;

    public Repository(Context context, ListCallback callback) {
        this.context = context;
        this.callback = callback;
        gson = new GsonBuilder()
                .setLenient()
                .create();
    }

    static final String BASE_URL = "https://www.expedia.com/lx/api/";
    public void getActivities(String location, String startDate, String endDate) {
        System.out.println("nikita");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        SearchAPI searchAPI = retrofit.create(SearchAPI.class);

        Call<SearchActivitiesResponse> call = searchAPI.getActivities(location, startDate, endDate);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<SearchActivitiesResponse> call, Response<SearchActivitiesResponse> response) {
        if(response.isSuccessful()) {
            SearchActivitiesResponse activitiesResponse = response.body();
            callback.onSuccess(activitiesResponse);
        } else {
            System.out.println(response.errorBody());
            callback.onSuccess(gson.fromJson(getMockResponse(), SearchActivitiesResponse.class));
        }
    }

    @Override
    public void onFailure(Call<SearchActivitiesResponse> call, Throwable t) {
        t.printStackTrace();
    }

    public interface ListCallback {
        void onSuccess(SearchActivitiesResponse reponse) ;

        void onFail() ;
    }

    private  String getMockResponse() {
        return "{\"total\":3,\"activities\":[{\"id\":\"249812\",\"title\":\"Plaza Premium Lounge at Kempegowda International Airport\",\"imageUrl\":\"https://mediaim.expedia.com/localexpert/249812/d9b7483f-0817-4726-8d5b-65ccb83bc1bf.jpg?impolicy=resizecrop&rw=350&rh=197\",\"largeImageURL\":\"https://mediaim.expedia.com/localexpert/249812/d9b7483f-0817-4726-8d5b-65ccb83bc1bf.jpg?impolicy=resizecrop&rw=1005&rh=565\",\"fromPrice\":\"$19\",\"fromPriceValue\":\"18.83\",\"fromPriceLabel\":\"per traveler\",\"duration\":\"3h\",\"durationInMillis\":10800000,\"fromPriceTicketType\":\"traveler\",\"fromPriceTicketCode\":\"Traveler\",\"freeCancellation\":true,\"formattedTitle\":\"plaza-premium-lounge-at-kempegowda-international-airport.a249812.activity-details\",\"categories\":[\"Food & Drink\",\"Spa\"],\"latLng\":\"13.1986348,77.7065928\",\"redemptionType\":\"Voucherless\",\"supplierName\":\"Plaza Premium Lounge\",\"recommendationScore\":70,\"scoreOutOf5\":3.5,\"reviewScoreThresholdMet\":true,\"hotelPickupEnabled\":false,\"approvedReviewCount\":5,\"shortDescription\":null,\"isBoostedNewActivity\":false,\"promoPricingAvailable\":false,\"redemptionLocations\":[\"13.1986348,77.7065928\"]},{\"id\":\"565996\",\"title\":\"Bengaluru Airport Same Day Luggage Services\",\"imageUrl\":\"https://mediaim.expedia.com/localexpert/565996/40737cd2-919b-4e31-ae28-64b90b450c54.jpg?impolicy=resizecrop&rw=350&rh=197\",\"largeImageURL\":\"https://mediaim.expedia.com/localexpert/565996/40737cd2-919b-4e31-ae28-64b90b450c54.jpg?impolicy=resizecrop&rw=1005&rh=565\",\"fromPrice\":\"$25\",\"fromPriceValue\":\"25.0\",\"fromPriceLabel\":\"per traveler\",\"duration\":\"6h\",\"durationInMillis\":21600000,\"fromPriceTicketType\":\"traveler\",\"fromPriceTicketCode\":\"Traveler\",\"freeCancellation\":true,\"formattedTitle\":\"bengaluru-airport-same-day-luggage-services.a565996.activity-details\",\"categories\":[\"Tours & Sightseeing\"],\"latLng\":\"12.9715987,77.5945627\",\"redemptionType\":\"Voucherless\",\"supplierName\":\"LuggAgent\",\"recommendationScore\":0,\"scoreOutOf5\":0.0,\"reviewScoreThresholdMet\":false,\"hotelPickupEnabled\":true,\"shortDescription\":null,\"isBoostedNewActivity\":false,\"promoPricingAvailable\":false,\"redemptionLocations\":[\"13.1986348,77.7065928\",\"12.9715987,77.5945627\"]},{\"id\":\"572631\",\"title\":\"Customizable Bali Tour with 12-Seater Mini Bus and Driver\",\"imageUrl\":\"https://mediaim.expedia.com/localexpert/572631/0922c767-fe71-44fa-9a14-5f29492c46aa.jpg?impolicy=resizecrop&rw=350&rh=197\",\"largeImageURL\":\"https://mediaim.expedia.com/localexpert/572631/0922c767-fe71-44fa-9a14-5f29492c46aa.jpg?impolicy=resizecrop&rw=1005&rh=565\",\"fromPrice\":\"$197\",\"fromPriceValue\":\"196.63\",\"fromPriceLabel\":\"per traveler\",\"duration\":\"10h\",\"durationInMillis\":36000000,\"fromPriceTicketType\":\"traveler\",\"fromPriceTicketCode\":\"Traveler\",\"formattedTitle\":\"customizable-bali-tour-with-12-seater-mini-bus-and-driver.a572631.activity-details\",\"categories\":[\"Tours & Sightseeing\",\"Private Tours\"],\"latLng\":\"-8.3405389,115.0919509\",\"redemptionType\":\"Voucherless\",\"supplierName\":\"BST\",\"recommendationScore\":0,\"scoreOutOf5\":0.0,\"reviewScoreThresholdMet\":false,\"hotelPickupEnabled\":true,\"shortDescription\":null,\"isBoostedNewActivity\":false,\"promoPricingAvailable\":false,\"redemptionLocations\":[\"-8.7438879,115.1749801\",\"-8.4993763,115.5652961\",\"-8.6478175,115.1385192\",\"-8.6704582,115.2126293\",\"-8.7906945,115.1592718\",\"-8.7223957,115.1767095\",\"-8.700997,115.1740942\",\"12.9607008,77.7420707\",\"-8.7071782,115.2626236\",\"-8.6912894,115.1681653\",\"-8.4595561,115.0465991\",\"-8.7586798,115.2143892\",\"-8.3921715,115.2956118\",\"-8.7493146,115.1711298\",\"-8.5068536,115.2624778\",\"-8.7786571,115.1660509\"]}],\"isLocationRedirected\":false,\"distanceUnit\":\"miles\",\"regionId\":\"6053307\",\"destination\":\"Bengaluru\",\"fullName\":\"Bengaluru (and vicinity), India\",\"startDate\":\"2019-04-01\",\"endDate\":\"2019-04-15\",\"dateAdjusted\":true,\"filterCategories\":{\"Food & Drink\":{\"count\":1,\"displayValue\":\"Food & Drink\",\"categoryType\":\"Activities\",\"categoryTypeDisplayValue\":\"Activities\",\"categoryRank\":3,\"contextualDisplayValue\":\"1 food & drink activity in Bengaluru\",\"contextualSingularDisplayValue\":\"1 food & drink activity in Bengaluru\"},\"Private Tours\":{\"count\":1,\"displayValue\":\"Private tours\",\"categoryType\":\"Tours\",\"categoryTypeDisplayValue\":\"Tours\",\"categoryRank\":2,\"contextualDisplayValue\":\"1 private tour in Bengaluru\",\"contextualSingularDisplayValue\":\"1 private tour in Bengaluru\"},\"Spa\":{\"count\":1,\"displayValue\":\"Spa\",\"categoryType\":\"Activities\",\"categoryTypeDisplayValue\":\"Activities\",\"categoryRank\":3,\"contextualDisplayValue\":\"1 spa in Bengaluru\",\"contextualSingularDisplayValue\":\"1 spa in Bengaluru\"},\"Tours & Sightseeing\":{\"count\":2,\"displayValue\":\"Tours & sightseeing\",\"categoryType\":\"Tours\",\"categoryTypeDisplayValue\":\"Tours\",\"categoryRank\":2,\"contextualDisplayValue\":\"2 tours & sightseeing activities in Bengaluru\",\"contextualSingularDisplayValue\":\"1 tour or sightseeing activity in Bengaluru\"}},\"currencyCode\":\"USD\",\"status\":\"passed\"}";

    }

}
