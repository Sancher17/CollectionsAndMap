package com.example.alex.collectionsandmap.model;

import java.util.ArrayList;

public class CalculateArrayList {

    private MyData data = new MyData();

    ArrayList al = new ArrayList();

    public void calculate(){
        data.addToStart(al);
        data.addToMiddle(al);
        data.addToEnd(al);

    }


}
