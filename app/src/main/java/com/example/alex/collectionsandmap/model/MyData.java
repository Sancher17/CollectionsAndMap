package com.example.alex.collectionsandmap.model;

import com.example.alex.collectionsandmap.BackgroundTask;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.List;

import static com.example.alex.collectionsandmap.presenter.PresenterCollections.INPUT_NUMBER;

public class MyData {

    private static Logger LOGGER = new Logger(MyData.class);

    public int addToStart(List<Integer> list) {
        LOGGER.log("addToStart called");
        list.clear();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < INPUT_NUMBER; i++) {
            list.add(0, i);
        }
        LOGGER.log("addToStart // result: "+String.valueOf(System.currentTimeMillis() - t1));
        return (int) (System.currentTimeMillis() - t1);
    }

    public int addToMiddle(List<Integer> list) {
        list.clear();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < INPUT_NUMBER; i++) {
            list.add(list.size()/2, i);
        }
        return (int) (System.currentTimeMillis() - t1);
    }

    public int addToEnd(List<Integer> list) {
        list.clear();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < INPUT_NUMBER; i++) {
            list.add(i);
        }
        return (int) (System.currentTimeMillis() - t1);
    }

    public int search(List list, int index){

        long t1 = System.currentTimeMillis();
        list.get(index);
        return (int) (System.currentTimeMillis() - t1);
    }

    public int removeStart(List<Integer> list) {
        int size = list.size();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.remove(0);
        }
        return (int) (System.currentTimeMillis() - t1);
    }

    public int removeMiddle(List<Integer> list) {
        addToEnd(list);
        int size = list.size();
        long t1 = System.currentTimeMillis();
        for (int i = size; i > 0; i--) {
            list.remove(list.size()/2);
        }
        return (int) (System.currentTimeMillis() - t1);
    }

    public int removeEnd(List<Integer> list) {
        addToEnd(list);
        long t1 = System.currentTimeMillis();
        for (int i = list.size()-1; i > 0; i--) {
            list.remove(i);
        }
        return (int) (System.currentTimeMillis() - t1);
    }


}
