package com.example.hacknc2021.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
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
    private Switch day_night_mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        subList = findViewById(R.id.subscriptionList);
        plusButton = findViewById(R.id.plusButton);
        day_night_mode = findViewById(R.id.day_night_mode);

        subscriptions.add("Netflix..........13.99");
        subscriptions.add("Amazon...........6.49");
        subscriptions.add("Yahoo...........25.00");
        subscriptions.add("Hulu............12.99");

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

        day_night_mode.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        if (day_night_mode.isChecked()) {
                            day_night_mode.setText("DAY");
                            subscriptions.clear();
                            AppCompatDelegate
                                    .setDefaultNightMode(
                                            AppCompatDelegate
                                                    .MODE_NIGHT_YES);
                        }
                        else {
                            day_night_mode.setText("NIGHT");
                            subscriptions.clear();
                            AppCompatDelegate
                                    .setDefaultNightMode(
                                            AppCompatDelegate
                                                    .MODE_NIGHT_NO);
                        }
                    }
                });
    }
}