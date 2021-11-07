package com.example.hacknc2021.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hacknc2021.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;

        ViewHolder(final View itemView){
            super(itemView);
            titleTextView = itemView.findViewById(R.id.listTitle);
        }
    }

    private final List<ListItem> listItems;
    public ListAdapter(List<ListItem> listItems) { //constructor
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        //inflates the custom layout
        View contactView = inflater.inflate(R.layout.list_item, parent, false);
        //returns a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);
        //sets title
        TextView nameTextView = holder.titleTextView;
        nameTextView.setText(listItem._title);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
}
