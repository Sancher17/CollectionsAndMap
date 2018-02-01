package com.example.alex.collectionsandmap.presenter;

import com.example.alex.collectionsandmap.model.CalculateArrayList;
import com.example.alex.collectionsandmap.utils.Logger;

public class PresenterCollections {

    public static int INPUT_NUMBER = 50000;
    private static Logger LOGGER = new Logger(PresenterCollections.class);

    CalculateArrayList cal = new CalculateArrayList();


    public void inputData() {
        LOGGER.log("inputData");
        LOGGER.log("INPUT_NUMBER " + INPUT_NUMBER);
        cal.calculate();

    }


}
