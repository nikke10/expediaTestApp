package com.expedia.testapp.view.activity;

import android.os.Bundle;

import com.expedia.testapp.R;
import com.expedia.testapp.view.fragment.ListFragment;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Bengaluru");
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            addFragment(R.id.container, new ListFragment(), ListFragment.class.getSimpleName());
        }
    }
}
