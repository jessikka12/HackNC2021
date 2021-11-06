package com.example.hacknc2021.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bettergame.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImageView;
        TextView titleTextView;
        TextView amountTextView;

        ViewHolder(final View itemView){
            super(itemView);
            iconImageView = itemView.findViewById(R.id.listIcon);
            titleTextView = itemView.findViewById(R.id.listTitle);
            amountTextView = itemView.findViewById(R.id.listAmount);
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
        //sets icon
        ImageView iconImageView = holder.iconImageView;
        iconImageView.setImageResource(listItem._icon);
        //sets title
        TextView nameTextView = holder.titleTextView;
        nameTextView.setText(listItem._title);
        //sets amount
        TextView amountTextView = holder.amountTextView;
        if (listItem._amount > 0){
            amountTextView.setText(listItem._amount + "");
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
}
