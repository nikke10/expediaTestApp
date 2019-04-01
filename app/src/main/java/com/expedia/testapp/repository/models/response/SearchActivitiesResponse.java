package com.expedia.testapp.repository.models.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchActivitiesResponse {

    @SerializedName("total")
    private int total;

    @SerializedName("activities")
    private List<ExpActivity> activities;


    public int getTotal() {
        return total;
    }

    public List<ExpActivity> getActivities() {
        return activities;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setActivities(List<ExpActivity> activities) {
        this.activities = activities;
    }
}

