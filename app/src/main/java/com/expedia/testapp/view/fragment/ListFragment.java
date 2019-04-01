package com.expedia.testapp.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.expedia.testapp.R;

import com.expedia.testapp.injection.ListComponent;
import com.expedia.testapp.presenter.IActivitiesListContract;
import com.expedia.testapp.repository.models.response.SearchActivitiesResponse;
import com.expedia.testapp.view.activity.BaseActivity;
import com.expedia.testapp.view.adapter.ActivitiesListAdapter;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ListFragment extends Fragment implements IActivitiesListContract.IListView {

    private BaseActivity activity;
    private Unbinder unbinder;

    @BindView(R.id.total_text)
    TextView total;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @BindView(R.id.list)
    LinearLayout listLayout;


    @BindView(R.id.loader)
    ProgressBar progressBar;

    @BindView(R.id.error)
    RelativeLayout errorLayout;

    @BindView(R.id.error_btn)
    Button retryButton;

    @Inject IActivitiesListContract.IListPresenter presenter;

    @Override
    public void onAttach(Context context) {
        activity = (BaseActivity) context;
        super.onAttach(context);
        ListComponent.Initializer.init(getContext(), this).inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_list, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initUI() {
        retryButton.setOnClickListener((v) -> {
            presenter.onRetryClicked();
        });
        presenter.fetchActivities();
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorView() {
        errorLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showListView() {
        listLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorView(){
        errorLayout.setVisibility(View.GONE);
    }

    @Override
    public void setData(SearchActivitiesResponse response) {
        total.setText(response.getTotal() + " things to do near you");
        ActivitiesListAdapter adpater = new ActivitiesListAdapter(getActivity(), response.getActivities());
        recyclerView.setAdapter(adpater);
    }
}
