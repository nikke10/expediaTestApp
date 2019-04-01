package com.expedia.testapp.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Scope {
    @javax.inject.Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PerFragment {
    }

    @javax.inject.Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PerActivity {
    }

}
