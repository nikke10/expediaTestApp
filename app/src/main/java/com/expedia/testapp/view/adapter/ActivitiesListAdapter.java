package com.expedia.testapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.expedia.testapp.R;
import com.expedia.testapp.repository.models.response.ExpActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ActivitiesListAdapter extends RecyclerView.Adapter<ActivitiesListAdapter.ViewHolder>{

    private List<ExpActivity> activities;
    Context context;

    public ActivitiesListAdapter(Context context, List<ExpActivity> activities) {
        this.context = context;
        this.activities = activities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_item_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ExpActivity activity = activities.get(i);
        viewHolder.title.setText(activity.getTitle());
        viewHolder.duration.setText(activity.getDuration());
        viewHolder.price.setText(activity.getFromPrice());
        Picasso.with(context).load(activity.getImageUrl()).fit().into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView duration;
        TextView price;



        ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            duration = itemView.findViewById(R.id.duration);
            price = itemView.findViewById(R.id.price);
        }
    }
}
