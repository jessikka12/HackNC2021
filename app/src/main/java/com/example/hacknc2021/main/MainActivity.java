package com.example.hacknc2021.main;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hacknc2021.App;
import com.example.hacknc2021.R;
import com.example.hacknc2021.list.ItemClickSupport;
import com.example.hacknc2021.list.ListAdapter;
import com.example.hacknc2021.list.ListItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView searchBar;
    RecyclerView searchList;
    private Switch day_night_mode2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchBar = findViewById(R.id.searchBar);
        searchList = findViewById(R.id.searchList);
        day_night_mode2 = findViewById(R.id.day_night_mode2);

        searchBar.setOnQueryTextListener(this);
        List<ListItem> all = createSearchList();

        searchList.setAdapter(new ListAdapter(all));
        searchList.setLayoutManager(new LinearLayoutManager(this));

        ItemClickSupport.addTo(searchList).setOnItemClickListener((recyclerView, position, v) -> {
            // show types of subscriptions from provider
        });

        day_night_mode2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        if (day_night_mode2.isChecked()) {
                            day_night_mode2.setText("DAY");
                            AppCompatDelegate
                                    .setDefaultNightMode(
                                            AppCompatDelegate
                                                    .MODE_NIGHT_YES);
                        }
                        else {
                            day_night_mode2.setText("NIGHT");
                            AppCompatDelegate
                                    .setDefaultNightMode(
                                            AppCompatDelegate
                                                    .MODE_NIGHT_NO);
                        }
                    }
                });
    }

    private List<ListItem> createSearchList() {
        List<ListItem> listItems = new LinkedList<>();
        InputStream file = getResources().openRawResource(R.raw.subscriptions);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineArray = line.split(",");
                if (listItems.isEmpty() || !lineArray[0].equals(listItems.get(listItems.size() - 1).getTitle())) {
                    listItems.add(new ListItem(lineArray[0], -1));
                }
            }
        } catch (IOException e) {
            Toast.makeText(this.getApplicationContext(), "App fails at this point, I'm sorry. ", Toast.LENGTH_SHORT).show();
        }
        return listItems;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}