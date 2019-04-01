package com.expedia.testapp.injection;

import android.content.Context;

import com.expedia.testapp.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class ListPresenterModule {

    private Context context;
    private Repository.ListCallback callback;

    public ListPresenterModule(Context context, Repository.ListCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    @Provides
    @Scope.PerFragment
    Repository providesRepository() {
        return new Repository(context, callback);
    }
}
