package com.example.alex.collectionsandmap.dataMaps;

import com.example.alex.collectionsandmap.utils.Logger;

import java.util.ArrayList;

public class MapsData {

    private static Logger LOGGER = new Logger(MapsData.class);

    private String name;
    private String action;
    private int resultOfCalculation = 0;
    private boolean progressBar = false;

    public MapsData() {
    }

    public MapsData(String name, String action, int resultOfCalculation, boolean progressBar) {
        this.name = name;
        this.action = action;
        this.progressBar = progressBar;
        this.resultOfCalculation = resultOfCalculation;
    }

    public static ArrayList<MapsData> list = new ArrayList<>();

    public void addItemsInList() {
        LOGGER.log("addItemsInList called");
        String action = "add";
        for (int i = 1; i < 4; i++) {
            list.add(new MapsData("TreeMap", action, resultOfCalculation, progressBar));
            list.add(new MapsData("HashMap", action, resultOfCalculation, progressBar));
            switch (i) {
                case 1:
                    action = "search";
                    break;
                case 2:
                    action = "remove";
                    break;
                default:
                    break;
            }
        }
    }

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
}
