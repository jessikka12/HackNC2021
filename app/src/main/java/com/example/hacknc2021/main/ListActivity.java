package com.example.hacknc2021.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hacknc2021.R;
import com.example.hacknc2021.list.ListAdapter;
import com.example.hacknc2021.list.ListItem;

import java.util.LinkedList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    public static List<String> subscriptions = new LinkedList<>();
    RecyclerView subList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
//        subList.findViewById(R.id.subscriptionList);
//
//        List<ListItem> subs = ListItem.createList(subscriptions);
//        subList.setAdapter(new ListAdapter(subs));
//        subList.setLayoutManager(new LinearLayoutManager(this));

    }
}