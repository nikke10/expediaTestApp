package com.expedia.testapp.injection;

import android.content.Context;

import com.expedia.testapp.presenter.IActivitiesListContract;
import com.expedia.testapp.view.fragment.ListFragment;
import dagger.Component;

@Component(modules = {ListModule.class})
@Scope.PerFragment
public interface ListComponent {
    void inject(ListFragment listFragment);

    final class Initializer {
        private Initializer() {
        } // No instances.

        public static ListComponent init(Context context, IActivitiesListContract.IListView listView) {
            return DaggerListComponent.builder().listModule(new ListModule(context, listView)).build();
        }
    }
}
