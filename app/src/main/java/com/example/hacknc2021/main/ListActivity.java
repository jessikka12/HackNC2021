package com.example.hacknc2021.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hacknc2021.R;
import com.example.hacknc2021.list.ListAdapter;
import com.example.hacknc2021.list.ListItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    public static List<String> subscriptions = new LinkedList<>();
    public RecyclerView subList;
    public FloatingActionButton plusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        subList = findViewById(R.id.subscriptionList);
        plusButton = findViewById(R.id.plusButton);

        List<ListItem> subs = ListItem.createList(subscriptions);
        subList.setAdapter(new ListAdapter(subs));
        subList.setLayoutManager(new LinearLayoutManager(this));

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(toMain);
            }
        });
    }
}