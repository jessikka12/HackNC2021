package com.example.hacknc2021.main;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hacknc2021.R;
import com.example.hacknc2021.list.ListAdapter;
import com.example.hacknc2021.list.ListItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView searchBar;
    RecyclerView searchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchBar = findViewById(R.id.searchBar);
        searchList = findViewById(R.id.searchList);

        searchBar.setOnQueryTextListener(this);
        List<ListItem> all = ListItem.createSearchList();
        searchList.setAdapter(new ListAdapter(all));
        searchList.setLayoutManager(new LinearLayoutManager(this));
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