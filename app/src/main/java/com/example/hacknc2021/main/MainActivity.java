package com.example.hacknc2021.main;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hacknc2021.R;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchBar = findViewById(R.id.searchBar);

        searchBar.setOnQueryTextListener(this);

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