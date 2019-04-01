package com.expedia.testapp.injection;

import android.content.Context;

import com.expedia.testapp.presenter.ActivitiesListPresenter;
import com.expedia.testapp.presenter.IActivitiesListContract;
import dagger.Module;
import dagger.Provides;

@Module
public class ListModule {
    private Context context;
    private IActivitiesListContract.IListView listView;

    public ListModule(Context context, IActivitiesListContract.IListView listView) {
        this.context = context;
        this.listView = listView;
    }

    @Provides
    @Scope.PerFragment
    IActivitiesListContract.IListPresenter provideListPresenter() {
        return new ActivitiesListPresenter(listView, context);
    }
}
