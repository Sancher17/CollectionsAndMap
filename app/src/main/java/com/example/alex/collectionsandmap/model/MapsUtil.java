package com.example.alex.collectionsandmap.model;

import com.example.alex.collectionsandmap.utils.Logger;

import java.util.List;
import java.util.Map;

import static com.example.alex.collectionsandmap.view.MainActivity.INPUT_NUMBER;


public class MapsUtil {

    private static Logger LOGGER = new Logger(MapsUtil.class);

    synchronized public static int add(Map map) {
        map.clear();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < INPUT_NUMBER; i++) {
            map.put(i, "Map" + i);
        }
        int result = (int) (System.currentTimeMillis() - t1);
        LOGGER.log("add // map size: " + map.size() + "// result " +result);
        return result;
    }

    synchronized public static int search(Map map) {
        map.clear();
        add(map);
        long t1 = System.currentTimeMillis();
        int value = INPUT_NUMBER / 2;
        map.get(value);
        int result = (int) (System.currentTimeMillis() - t1);
        LOGGER.log("search // get value: " + value + "//map size " + map.size() + "// result " + result);
        return result;
    }

    synchronized public static int remove(Map map) {
        LOGGER.log("remove // map size: " + map.size());
        int size = map.size();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            map.remove(i);
        }
        int result = (int) (System.currentTimeMillis() - t1);
        LOGGER.log("remove // map size: " + map.size()+"// result " + result);
        return result;
    }

}

