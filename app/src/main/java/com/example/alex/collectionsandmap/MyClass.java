package com.example.alex.collectionsandmap;

import com.example.alex.collectionsandmap.utils.Logger;
import com.example.alex.collectionsandmap.view.FragmentTab1;

public class MyClass implements MyCallback{

    private static Logger LOGGER = new Logger(MyClass.class);


    @Override
    public void callbackCall() {
        LOGGER.log("callbackCall called");
        FragmentTab1.adapter.notifyItemChanged(0);
    }
}
