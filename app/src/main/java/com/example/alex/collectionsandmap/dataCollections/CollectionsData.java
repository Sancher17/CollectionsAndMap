package com.example.alex.collectionsandmap.dataCollections;

import com.example.alex.collectionsandmap.utils.Logger;

import java.util.ArrayList;

import javax.inject.Inject;

public class CollectionsData implements CollectionsRepository {

    private static Logger LOGGER = new Logger(CollectionsData.class);

    private String name;
    private String action;
    private int resultOfCalculation = 0;
    private boolean progressBar = false;

    @Inject
    public CollectionsData() {
    }

    public CollectionsData(String name, String action, int resultOfCalculation, boolean progressBar) {
        this.name = name;
        this.action = action;
        this.progressBar = progressBar;
        this.resultOfCalculation = resultOfCalculation;
    }

    public static ArrayList<CollectionsData> list = new ArrayList<>();

    //getter - setter
    public String getAction() {
        return action;
    }

    public boolean getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(boolean progressBar) {
        this.progressBar = progressBar;
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


    @Override
    public void createData() {
        LOGGER.log("createData");
        String action = "add to start";
        for (int i = 1; i < 8; i++) {
            list.add(new CollectionsData("ArrayList", action, resultOfCalculation, progressBar));
            list.add(new CollectionsData("LinkedList", action, resultOfCalculation, progressBar));
            list.add(new CollectionsData("COWArrayList", action, resultOfCalculation, progressBar));
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


}

/**heap*/
//    public static ArrayList<CollectionsData> list = new ArrayList<>(Arrays.asList(
//            new CollectionsData("ArrayList", "add to start",4 , 0),
//            new CollectionsData("ArrayList", "add to rasdd", 1, 0)));
//
//
//    public static final ArrayList<CollectionsData> list = new ArrayList<>(Arrays.asList(
//            new CollectionsData(al, "add to"+start,4 , progressBar),
//            new CollectionsData(ll, "add to"+start, 1, 0),
//            new CollectionsData(cowal, "add to"+start, resultOfCalculation, progressBar),
//            new CollectionsData(al, "add to"+middle, resultOfCalculation, progressBar),
//            new CollectionsData(ll, "add to"+middle, resultOfCalculation, progressBar),
//            new CollectionsData(cowal, "add to"+middle, resultOfCalculation, progressBar),
//            new CollectionsData(al, "add to"+end, resultOfCalculation, progressBar),
//            new CollectionsData(ll, "add to"+end, resultOfCalculation, progressBar),
//            new CollectionsData(cowal, "add to"+end, resultOfCalculation, progressBar),
//            new CollectionsData(al, "search", resultOfCalculation, progressBar),
//            new CollectionsData(ll, "search", resultOfCalculation, progressBar),
//            new CollectionsData(cowal, "search", resultOfCalculation, progressBar),
//            new CollectionsData(al, "dell from"+start, resultOfCalculation, progressBar),
//            new CollectionsData(ll, "dell from"+start, resultOfCalculation, progressBar),
//            new CollectionsData(cowal, "dell from"+start, resultOfCalculation, progressBar),
//            new CollectionsData(al, "dell from"+middle, resultOfCalculation, progressBar),
//            new CollectionsData(ll, "dell from"+middle, resultOfCalculation, progressBar),
//            new CollectionsData(cowal, "dell from"+middle, resultOfCalculation, progressBar),
//            new CollectionsData(al, "dell from"+end, resultOfCalculation, progressBar),
//            new CollectionsData(ll, "dell from"+end, resultOfCalculation, progressBar),
//            new CollectionsData(cowal, "dell from"+end, resultOfCalculation, progressBar)
//    ));
//    private String al = "ArrayList";
//    private String ll = "LinkedList";
//    private String cowal = "COWArrayList";
//    private String start = " start";
//    private String middle = " middle";
//    private String end = " end";

//    CollectionsData[] collectionsData = {
//            (new CollectionsData(al, "add to start", 1, progressBar)),
//            new CollectionsData(ll, "add to start", 2, progressBar),
//            new CollectionsData(cowal, "add to start", resultOfCalculation, progressBar),
//            new CollectionsData(al, "add to middle", resultOfCalculation, progressBar),
//            new CollectionsData(ll, "add to" + middle, resultOfCalculation, progressBar),
//            new CollectionsData(cowal, "add to" + middle, resultOfCalculation, progressBar),
//            new CollectionsData(al, "add to" + end, resultOfCalculation, progressBar),
//            new CollectionsData(ll, "add to" + end, resultOfCalculation, progressBar),
//            new CollectionsData(cowal, "add to" + end, resultOfCalculation, progressBar),
//            new CollectionsData(al, "search", resultOfCalculation, progressBar),
//            new CollectionsData(ll, "search", resultOfCalculation, progressBar),
//            new CollectionsData(cowal, "search", resultOfCalculation, progressBar),
//            new CollectionsData(al, "dell from" + start, resultOfCalculation, progressBar),
//            new CollectionsData(ll, "dell from" + start, resultOfCalculation, progressBar),
//            new CollectionsData(cowal, "dell from" + start, resultOfCalculation, progressBar),
//            new CollectionsData(al, "dell from" + middle, resultOfCalculation, progressBar),
//            new CollectionsData(ll, "dell from" + middle, resultOfCalculation, progressBar),
//            new CollectionsData(cowal, "dell from" + middle, resultOfCalculation, progressBar),
//            new CollectionsData(al, "dell from" + end, resultOfCalculation, progressBar),
//            new CollectionsData(ll, "dell from" + end, resultOfCalculation, progressBar),
//            new CollectionsData(cowal, "dell from" + end, resultOfCalculation, progressBar)
//    };

//    public ArrayList<CollectionsData> list = new ArrayList<>(Arrays.asList(collectionsData));
//    public static ArrayList<CollectionsData> list = new ArrayList<>();
//    public static ArrayList <CollectionsData> list = new ArrayList<>();