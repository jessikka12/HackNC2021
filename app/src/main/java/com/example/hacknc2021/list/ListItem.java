package com.example.hacknc2021.list;

import java.util.LinkedList;
import java.util.List;

public class ListItem {

    String _title;
    int _amount;


    public ListItem(String title, int amount) {
        _title = title;
        _amount = amount;
    }

    public String getTitle() {
        return _title;
    }

    /* creating listItems used in ListAdapter */

    public static List<ListItem> createList(List<String> list) {
        if (!list.isEmpty()) {
            List<ListItem> listItems = new LinkedList<>();
            for (String item : list) {
                listItems.add(new ListItem(item, -1));
            }
            return listItems;
        } else {
            return new LinkedList<>();
        }
    }
}