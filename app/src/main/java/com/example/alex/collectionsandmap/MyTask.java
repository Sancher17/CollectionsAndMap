package com.example.alex.collectionsandmap;

import android.os.AsyncTask;
import android.widget.TextView;

import com.example.alex.collectionsandmap.model.MyData;
import com.example.alex.collectionsandmap.utils.Logger;
import com.example.alex.collectionsandmap.view.MainActivity;

import java.util.ArrayList;

public class MyTask extends AsyncTask <Integer, Void, String> {

    private static Logger LOGGER = new Logger(MainActivity.class);

    MyData md = new MyData();
    ArrayList al = new ArrayList();


    int result = 0;

    @Override
    protected String doInBackground(Integer... number) {
        LOGGER.log("doInBackground");
        result = md.addToStart(al);
        return null;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        s = String.valueOf(result);
        LOGGER.log("onPostExecute " + s);

    }
}

