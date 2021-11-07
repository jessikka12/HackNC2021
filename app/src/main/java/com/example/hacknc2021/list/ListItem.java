package com.example.hacknc2021.list;

import android.content.SharedPreferences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ListItem {

    String _title;

    public ListItem(String title) {
        _title = title;
    }

    public String getTitle() {
        return _title;
    }

    /* creating listItems used in ListAdapter */

    public static List<ListItem> createList() {
        return new LinkedList<>();
    }
}