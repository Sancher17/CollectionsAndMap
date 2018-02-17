package com.example.alex.collectionsandmap.model;

import com.example.alex.collectionsandmap.utils.Logger;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionsData {

    private static Logger LOGGER = new Logger(CollectionsData.class);

    private String name;
    private String action;
    private int resultOfCalculation = 0;
    private int flag = 1;

    public CollectionsData() {
    }

    public CollectionsData(String name, String action, int resultOfCalculation, int flag) {
        this.name = name;
        this.action = action;
        this.flag = flag;
        this.resultOfCalculation = resultOfCalculation;
    }

    public static ArrayList<CollectionsData> list = new ArrayList<>();

    public void addItemsInList() {
        LOGGER.log("addItemsInList called");
        String action = "add to start";
        for (int i = 1; i < 8; i++) {
            list.add(new CollectionsData("ArrayList", action, resultOfCalculation, flag));
            list.add(new CollectionsData("LinkedList", action, resultOfCalculation, flag));
            list.add(new CollectionsData("COWArrayList", action, resultOfCalculation, flag));
            switch (i) {
                case 1:
                    action = "add to middle";
                    break;
                case 2:
                    action = "add to end";
                    break;
                case 3:
                    action = "search";
                    break;
                case 4:
                    action = "del from start";
                    break;
                case 5:
                    action = "del from middle";
                    break;
                case 6:
                    action = "del from end";
                default:
                    break;
            }
        }
    }

    public String getAction() {
        return action;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public int getResultOfCalculation() {
        return resultOfCalculation;
    }

    public void setResultOfCalculation(int resultOfCalculation) {
        this.resultOfCalculation = resultOfCalculation;
    }
}


//    public static ArrayList<CollectionsData> list = new ArrayList<>(Arrays.asList(
//            new CollectionsData("ArrayList", "add to start",4 , 0),
//            new CollectionsData("ArrayList", "add to rasdd", 1, 0)));
//
//
//    public static final ArrayList<CollectionsData> list = new ArrayList<>(Arrays.asList(
//            new CollectionsData(al, "add to"+start,4 , flag),
//            new CollectionsData(ll, "add to"+start, 1, 0),
//            new CollectionsData(cowal, "add to"+start, resultOfCalculation, flag),
//            new CollectionsData(al, "add to"+middle, resultOfCalculation, flag),
//            new CollectionsData(ll, "add to"+middle, resultOfCalculation, flag),
//            new CollectionsData(cowal, "add to"+middle, resultOfCalculation, flag),
//            new CollectionsData(al, "add to"+end, resultOfCalculation, flag),
//            new CollectionsData(ll, "add to"+end, resultOfCalculation, flag),
//            new CollectionsData(cowal, "add to"+end, resultOfCalculation, flag),
//            new CollectionsData(al, "search", resultOfCalculation, flag),
//            new CollectionsData(ll, "search", resultOfCalculation, flag),
//            new CollectionsData(cowal, "search", resultOfCalculation, flag),
//            new CollectionsData(al, "dell from"+start, resultOfCalculation, flag),
//            new CollectionsData(ll, "dell from"+start, resultOfCalculation, flag),
//            new CollectionsData(cowal, "dell from"+start, resultOfCalculation, flag),
//            new CollectionsData(al, "dell from"+middle, resultOfCalculation, flag),
//            new CollectionsData(ll, "dell from"+middle, resultOfCalculation, flag),
//            new CollectionsData(cowal, "dell from"+middle, resultOfCalculation, flag),
//            new CollectionsData(al, "dell from"+end, resultOfCalculation, flag),
//            new CollectionsData(ll, "dell from"+end, resultOfCalculation, flag),
//            new CollectionsData(cowal, "dell from"+end, resultOfCalculation, flag)
//    ));

//    private String al = "ArrayList";
//    private String ll = "LinkedList";
//    private String cowal = "COWArrayList";
//    private String start = " start";
//    private String middle = " middle";
//    private String end = " end";

//    CollectionsData[] collectionsData = {
//            (new CollectionsData(al, "add to start", 1, flag)),
//            new CollectionsData(ll, "add to start", 2, flag),
//            new CollectionsData(cowal, "add to start", resultOfCalculation, flag),
//            new CollectionsData(al, "add to middle", resultOfCalculation, flag),
//            new CollectionsData(ll, "add to" + middle, resultOfCalculation, flag),
//            new CollectionsData(cowal, "add to" + middle, resultOfCalculation, flag),
//            new CollectionsData(al, "add to" + end, resultOfCalculation, flag),
//            new CollectionsData(ll, "add to" + end, resultOfCalculation, flag),
//            new CollectionsData(cowal, "add to" + end, resultOfCalculation, flag),
//            new CollectionsData(al, "search", resultOfCalculation, flag),
//            new CollectionsData(ll, "search", resultOfCalculation, flag),
//            new CollectionsData(cowal, "search", resultOfCalculation, flag),
//            new CollectionsData(al, "dell from" + start, resultOfCalculation, flag),
//            new CollectionsData(ll, "dell from" + start, resultOfCalculation, flag),
//            new CollectionsData(cowal, "dell from" + start, resultOfCalculation, flag),
//            new CollectionsData(al, "dell from" + middle, resultOfCalculation, flag),
//            new CollectionsData(ll, "dell from" + middle, resultOfCalculation, flag),
//            new CollectionsData(cowal, "dell from" + middle, resultOfCalculation, flag),
//            new CollectionsData(al, "dell from" + end, resultOfCalculation, flag),
//            new CollectionsData(ll, "dell from" + end, resultOfCalculation, flag),
//            new CollectionsData(cowal, "dell from" + end, resultOfCalculation, flag)
//    };

//    public ArrayList<CollectionsData> list = new ArrayList<>(Arrays.asList(collectionsData));
//    public static ArrayList<CollectionsData> list = new ArrayList<>();
//    public static ArrayList <CollectionsData> list = new ArrayList<>();