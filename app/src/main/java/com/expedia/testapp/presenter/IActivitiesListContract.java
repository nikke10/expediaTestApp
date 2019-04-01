package com.expedia.testapp.presenter;

import com.expedia.testapp.repository.models.response.SearchActivitiesResponse;

public interface IActivitiesListContract {
    interface IListPresenter {
        void fetchActivities();
        void onRetryClicked();
    }

    interface IListView {
        void showLoading();
        void showErrorView();
        void hideLoading();
        void showListView();
        void hideErrorView();
        void setData(SearchActivitiesResponse response);
    }
}
