package com.expedia.testapp.injection;

import android.content.Context;

import com.expedia.testapp.presenter.IActivitiesListContract;
import com.expedia.testapp.repository.Repository;

import dagger.Component;

@Component(modules = {ListPresenterModule.class})
@Scope.PerFragment
public interface ListPresenterComponent {
    void inject(IActivitiesListContract.IListPresenter presenter);

    final class Initializer {
        private Initializer() {
        } // No instances.

        public static ListPresenterComponent init(Context context, Repository.ListCallback callback) {
            return DaggerListPresenterComponent.builder().listPresenterModule(new ListPresenterModule(context, callback)).build();
        }
    }
}
