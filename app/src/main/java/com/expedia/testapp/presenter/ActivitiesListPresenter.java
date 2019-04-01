package com.expedia.testapp.presenter;

import android.content.Context;

import com.expedia.testapp.repository.Repository;
import com.expedia.testapp.repository.models.response.SearchActivitiesResponse;


public class ActivitiesListPresenter implements IActivitiesListContract.IListPresenter, Repository.ListCallback {

    IActivitiesListContract.IListView listView;
    Context context;
    Repository repository;

    public ActivitiesListPresenter(IActivitiesListContract.IListView listView, Context context) {
        this.listView = listView;
        this.context = context;
        repository = new Repository(context, this);
    }

    @Override
    public void fetchActivities() {
        listView.showLoading();
        repository.getActivities("Bengaluru", "2019-04-01", "2019-04-15");
    }

    @Override
    public void onSuccess(SearchActivitiesResponse response) {
        listView.hideLoading();
        listView.showListView();
        listView.setData(response);
    }

    @Override
    public void onFail() {
        listView.hideLoading();
        listView.showErrorView();
    }

    public void onRetryClicked() {
        listView.hideErrorView();
        fetchActivities();
    }
}
