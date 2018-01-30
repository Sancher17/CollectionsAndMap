package com.example.alex.collectionsandmap.presenter;

import com.example.alex.collectionsandmap.utils.Logger;

public class Presenter {


    public static int INPUT_NUMBER = 0;

    private static Logger LOGGER = new Logger(Presenter.class);

    public void inputData() {
        LOGGER.log("inputData");
        LOGGER.log("INPUT_NUMBER " + INPUT_NUMBER);
    }


}
