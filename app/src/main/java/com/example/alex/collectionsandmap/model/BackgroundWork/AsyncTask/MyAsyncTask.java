package com.example.alex.collectionsandmap.model.BackgroundWork.AsyncTask;

import android.os.AsyncTask;

import com.example.alex.collectionsandmap.model.CollectionsProcessor;
import com.example.alex.collectionsandmap.repository.CollectionsData;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyAsyncTask extends AsyncTask <Void, Void, Void> {

    private static Logger LOGGER = new Logger(MyAsyncTask.class);

    ArrayList al = new ArrayList();
    LinkedList ll = new LinkedList();
    CopyOnWriteArrayList cow = new CopyOnWriteArrayList();



    @Override
    protected Void doInBackground(Void... voids) {
        LOGGER.log("doInBackground called");
//        CollectionsData.list.get(0).setResultOfCalculation(CollectionsProcessor.addToStart(al));
        return null;
    }

    @Override
    protected void onPreExecute() {
        LOGGER.log("onPreExecute called");
//        CollectionsData.list.get(0).setProgressBar(0);
//        CollectionsData.list.get(1).setProgressBar(0);
//        CollectionsData.list.get(2).setProgressBar(0);
//        FragmentTab1.adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        LOGGER.log("onPostExecute called");
//        CollectionsData.list.get(0).setProgressBar(1);
//        CollectionsData.list.get(1).setProgressBar(0);
//        CollectionsData.list.get(2).setProgressBar(0);
//        FragmentTab1.adapter.notifyDataSetChanged();
    }
}

