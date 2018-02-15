package com.example.alex.collectionsandmap;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alex.collectionsandmap.model.CollectionsData;
import com.example.alex.collectionsandmap.model.MyData;
import com.example.alex.collectionsandmap.utils.Logger;
import com.example.alex.collectionsandmap.view.FragmentTab1;
import com.example.alex.collectionsandmap.view.MainActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyTask extends AsyncTask <Void, Void, Void> {

    private static Logger LOGGER = new Logger(MyTask.class);

    MyData myData = new MyData();
    ArrayList al = new ArrayList();
    LinkedList ll = new LinkedList();
    CopyOnWriteArrayList cow = new CopyOnWriteArrayList();



    @Override
    protected Void doInBackground(Void... voids) {
        LOGGER.log("doInBackground called");
        CollectionsData.list.get(0).setResultOfCalculation(myData.addToStart(al));
        return null;
    }

    @Override
    protected void onPreExecute() {
        LOGGER.log("onPreExecute called");
        CollectionsData.list.get(0).setFlag(0);
        CollectionsData.list.get(1).setFlag(0);
        CollectionsData.list.get(2).setFlag(0);
        FragmentTab1.adapter.notifyDataSetChanged();
//        Toast.makeText(context,"Let is start", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        LOGGER.log("onPostExecute called");
        CollectionsData.list.get(0).setFlag(1);
        CollectionsData.list.get(1).setFlag(1);
        CollectionsData.list.get(2).setFlag(1);
        FragmentTab1.adapter.notifyDataSetChanged();
    }
}

