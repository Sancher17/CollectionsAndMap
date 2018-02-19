package com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService;


import android.support.v7.app.AppCompatActivity;

import com.example.alex.collectionsandmap.model.IMaps;
import com.example.alex.collectionsandmap.repository.MapsData;
import com.example.alex.collectionsandmap.model.MapsProcessor;
import com.example.alex.collectionsandmap.utils.Logger;
import com.example.alex.collectionsandmap.view.FragmentTab2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMap extends AppCompatActivity {

    private static Logger LOGGER = new Logger(ExecutorCollection.class);
    private TreeMap treeMap = new TreeMap();
    private HashMap hashMap = new HashMap();

    private int core = Runtime.getRuntime().availableProcessors();

    private ExecutorService executor = Executors.newFixedThreadPool(core+1);

    void runBackground(final int position, final Map map, IMaps func) {
        LOGGER.log("runBackground called // position " + position);
        MapsData.list.get(position).setProgressBar(true);
        MapsData.list.get(position).setResultOfCalculation(0);
        FragmentTab2.adapter.notifyDataSetChanged();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                LOGGER.log("run called");
                LOGGER.log("Thread // " + executor.toString()+ " // "+ Thread.currentThread().getName());
                int result = func.startMap(map);
                MapsData.list.get(position).setResultOfCalculation(result);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LOGGER.log("runOnUiThread // position " + position + " // result " + result);
                        MapsData.list.get(position).setProgressBar(false);
                        FragmentTab2.adapter.notifyItemChanged(position);
                    }
                });
            }
        });
    }

    public void doTask() {
        LOGGER.log("doTask called");
        LOGGER.log("quantity of CPU " + core);
        runBackground(0, treeMap, MapsProcessor::add);
        runBackground(1, hashMap, MapsProcessor::add);

        runBackground(2, treeMap, MapsProcessor::search);
        runBackground(3, hashMap, MapsProcessor::search);

        runBackground(4, treeMap, MapsProcessor::remove);
        runBackground(5, hashMap, MapsProcessor::remove);



    }
}

