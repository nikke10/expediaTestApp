package com.expedia.testapp.repository.models.response;

import com.google.gson.annotations.SerializedName;

public class ExpActivity {
    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("fromPrice")
    private String fromPrice;

    @SerializedName("fromPriceLabel")
    private String fromPriceLabel;

    @SerializedName("duration")
    private String duration;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setFromPrice(String fromPrice) {
        this.fromPrice = fromPrice;
    }

    public void setFromPriceLabel(String fromPriceLabel) {
        this.fromPriceLabel = fromPriceLabel;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getFromPrice() {
        return fromPrice;
    }

    public String getFromPriceLabel() {
        return fromPriceLabel;
    }

    public String getDuration() {
        return duration;
    }
}
