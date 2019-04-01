package com.expedia.testapp.repository.models.response;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ModelsTest {

    @Test
    public void expActivityText() {
        ExpActivity activity =  new ExpActivity();
        Assert.assertNull(activity.getTitle());
        Assert.assertNull(activity.getDuration());
        Assert.assertNull(activity.getFromPrice());
        Assert.assertNull(activity.getImageUrl());

        activity = getExpActivity();
        Assert.assertEquals("3h", activity.getDuration());
        Assert.assertEquals("Airport Lounge", activity.getTitle());
        Assert.assertEquals("$22", activity.getFromPrice());
        Assert.assertEquals("https://mediaim.expedia.com/localexpert/249812/d9b7483f-0817-4726-8d5b-65ccb83bc1bf.jpg?impolicy=resizecrop&rw=350&rh=197", activity.getImageUrl());

    }

    @Test
    public void searchActivitiesResponseTest() {
        SearchActivitiesResponse response = new SearchActivitiesResponse();
        Assert.assertEquals(0, response.getTotal());
        Assert.assertNull(response.getActivities());

        response.setTotal(300);
        Assert.assertEquals(300, response.getTotal());

        List<ExpActivity> list = new ArrayList<>();
        list.add(getExpActivity());

        response.setActivities(list);
        Assert.assertEquals(list, response.getActivities());


    }

    ExpActivity getExpActivity() {
        ExpActivity activity = new ExpActivity();
        activity.setDuration("3h");
        activity.setTitle("Airport Lounge");
        activity.setFromPrice("$22");
        activity.setImageUrl("https://mediaim.expedia.com/localexpert/249812/d9b7483f-0817-4726-8d5b-65ccb83bc1bf.jpg?impolicy=resizecrop&rw=350&rh=197");
        return activity;
    }
}
