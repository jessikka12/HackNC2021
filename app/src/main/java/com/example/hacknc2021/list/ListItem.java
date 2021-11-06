package com.example.hacknc2021.list;

import android.content.SharedPreferences;

import com.example.bettergame.App;
import com.example.bettergame.Dragon;
import com.example.bettergame.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ListItem {

    int _icon;
    String _title;
    int _amount;

    public ListItem(int icon, String title, int amount) {
        _icon = icon;
        _title = title;
        _amount = amount;
    }

    public String getTitle() {
        return _title;
    }

    /* creating listItems used in ListAdapter */

    public static List<ListItem> createDragonList(List<Dragon> dragons) {
        List<ListItem> listItems = new ArrayList<>(dragons.size());
        for (Dragon dragon : dragons) {
            listItems.add(new ListItem(dragon.getImage(), dragon.getName(), -1));
        }
        return listItems;
    }

    public static List<ListItem> createCrystalList(Map<String, Integer> map) {
        List<ListItem> listItems = new ArrayList<>(5);
        listItems.add(new ListItem(R.drawable.crystalclear, App.res.getString(R.string.element_normal), -1));
        for (String key : map.keySet()) {
            listItems.add(new ListItem(getCrystalIcon(key), key, map.get(key)));
        }
        return listItems;
    }

    public static List<ListItem> createCollectionList(Map<String, Boolean> map) {
        List<ListItem> listItems = new ArrayList<>(15);
        for (String key : map.keySet()) {
            if (map.get(key)) {
                listItems.add(new ListItem(getHeadIcon(key), key, -1));
            } else {
                listItems.add(new ListItem(R.drawable.headempty, "???", -1));
            }
        }
        return listItems;
    }

    public static List<ListItem> createStoryList(SharedPreferences memory) {
        Object[] storyList = getStoryList();
        List<ListItem> listItems = new ArrayList<>(storyList.length);
        for (int i = 0; i < storyList.length; i++) {
            boolean unlocked = memory.getBoolean(App.res.getString(R.string.unlocked_boolean, i, 0), false);
            if (unlocked) {
                listItems.add(new ListItem(R.drawable.empty, (String) storyList[i], -1));
            } else {
                listItems.add(new ListItem(R.drawable.locked, "LOCKED", -1));
            }
        }
        return listItems;
    }

    public static List<ListItem> createChapterList(SharedPreferences memory, int storyIndex, SharedPreferences enemies) {
        List<ListItem> listItems = new ArrayList<>();
        InputStream file = App.res.openRawResource(getChapterList(storyIndex));
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line = reader.readLine();
            int counter = 0;
            while (line != null) {
                boolean unlocked = memory.getBoolean(App.res.getString(R.string.unlocked_boolean, storyIndex, counter), false);
                boolean incomplete = memory.getBoolean(App.res.getString(R.string.incomplete_boolean, storyIndex, counter), true);
                if (unlocked) {
                    if (incomplete) {
                        listItems.add(new ListItem(R.drawable.headempty, line, -1));
                    } else {
                        listItems.add(new ListItem(getHeadIcon(enemies.getString(App.res.getString(R.string.enemy_dragon_type, storyIndex, counter), App.res.getString(R.string.type_normal))), line, -1));
                    }
                } else {
                    listItems.add(new ListItem(R.drawable.locked, "LOCKED",  -1));
                }
                line = reader.readLine();
                counter++;
            }
        } catch (IOException ignored) {}
        return listItems;
    }

    private static int getHeadIcon(String type) {
        if (type.equals(App.res.getString(R.string.type_normal))) {
            return R.drawable.headnormal;
        } else if (type.equals(App.res.getString(R.string.type_red))) {
            return R.drawable.headred;
        } else if (type.equals(App.res.getString(R.string.type_water))) {
            return R.drawable.headwater;
        } else if (type.equals(App.res.getString(R.string.type_earth))) {
            return R.drawable.headearth;
        } else if (type.equals(App.res.getString(R.string.type_cloud))) {
            return R.drawable.headcloud;
        } else if (type.equals(App.res.getString(R.string.type_fire))) {
            return R.drawable.headfire;
        } else if (type.equals(App.res.getString(R.string.type_death))) {
            return R.drawable.headdeath;
        } else if (type.equals(App.res.getString(R.string.type_metal))) {
            return R.drawable.headmetal;
        } else if (type.equals(App.res.getString(R.string.type_chinese))) {
            return R.drawable.headchinese;
        } else if (type.equals(App.res.getString(R.string.type_sea))) {
            return R.drawable.headsea;
        } else if (type.equals(App.res.getString(R.string.type_nature))) {
            return R.drawable.headnature;
        } else if (type.equals(App.res.getString(R.string.type_ice))) {
            return R.drawable.headice;
        } else if (type.equals(App.res.getString(R.string.type_cave))) {
            return R.drawable.headcave;
        } else if (type.equals(App.res.getString(R.string.type_three))) {
            return R.drawable.headthree;
        } else if (type.equals(App.res.getString(R.string.type_bird))) {
            return R.drawable.headbird;
        } else {
            return R.drawable.headempty;
        }
    }

    private static int getCrystalIcon(String type) {
        if (type.equals(App.res.getString(R.string.element_fire))) {
            return R.drawable.crystalfire;
        } else if (type.equals(App.res.getString(R.string.element_water))) {
            return R.drawable.crystalwater;
        } else if (type.equals(App.res.getString(R.string.element_earth))) {
            return R.drawable.crystalearth;
        } else if (type.equals(App.res.getString(R.string.element_air))) {
            return R.drawable.crystalair;
        } else {
            return R.drawable.crystalclear;
        }
    }

    private static Object[] getStoryList() {
        LinkedList<String> list = new LinkedList<String>();
        InputStream file = App.res.openRawResource(R.raw.storylist);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line = reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException ignored) {}
        return list.toArray();
    }

    private static int getChapterList(int storyIndex) { // todo: update in future
        Object[] storyList = getStoryList();
        String story = (String) storyList[storyIndex];
        switch (story) {
            case "Visiting Home":
                return R.raw.visiting_home;
            case "Flashback: ED's Ascent to Power":
                return R.raw.fb_ascent_to_power;
            case "Biology: Normal Dragon":
                return R.raw.b_normal;
            case "Seeking Help":
                return R.raw.seeking_help;
            default:
                return R.raw.storylist;
        }
    }
}