package com.example.hacknc2021.list;

import java.util.LinkedList;
import java.util.List;

public class ListItem {

    String _title;

    public ListItem(String title) {
        _title = title;
    }

    public String getTitle() {
        return _title;
    }

    /* creating listItems used in ListAdapter */

    public static List<ListItem> createList(List<String> list) {
        List<ListItem> listItems = new LinkedList<>();
        for (String item:list) {
            listItems.add(new ListItem(item));
        }
        return listItems;
    }

    public static List<ListItem> createSearchList() {
        return new LinkedList<>();
    }
}