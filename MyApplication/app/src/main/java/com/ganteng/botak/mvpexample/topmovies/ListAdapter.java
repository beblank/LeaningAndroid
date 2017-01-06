package com.ganteng.botak.mvpexample.topmovies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ganteng.botak.mvpexample.R;

import java.util.List;

/**
 * Created by adityahadiwijaya on 1/4/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder> {

    private List<ViewModel> list;

    public ListAdapter(List<ViewModel> list) {
        this.list = list;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent,false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {

        holder.itemName.setText(list.get(position).getName());
        holder.countryName.setText(list.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ListItemViewHolder extends RecyclerView.ViewHolder {

        public TextView itemName;
        public TextView countryName;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            itemName = (TextView)itemView.findViewById(R.id.textView_fragmentList_task_name);
            countryName = (TextView)itemView.findViewById(R.id.textView_fragmentList_countery_name);
        }

    }
}


