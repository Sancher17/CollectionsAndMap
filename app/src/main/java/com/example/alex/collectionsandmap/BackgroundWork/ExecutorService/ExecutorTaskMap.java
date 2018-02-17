package com.example.alex.collectionsandmap.BackgroundWork.ExecutorService;


import android.support.v7.app.AppCompatActivity;

import com.example.alex.collectionsandmap.model.CollectionsUtil;
import com.example.alex.collectionsandmap.model.DataInterfaceCollections;
import com.example.alex.collectionsandmap.model.DataInterfaceMaps;
import com.example.alex.collectionsandmap.model.MapsData;
import com.example.alex.collectionsandmap.model.MapsUtil;
import com.example.alex.collectionsandmap.utils.Logger;
import com.example.alex.collectionsandmap.view.FragmentTab2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTaskMap extends AppCompatActivity {

    private static Logger LOGGER = new Logger(ExecutorTaskCollection.class);
    private TreeMap treeMap = new TreeMap();
    private HashMap hashMap = new HashMap();

    private int core = Runtime.getRuntime().availableProcessors();

    ExecutorService executor = Executors.newFixedThreadPool(core*2);

    void runBackground(final int position, final Map map, DataInterfaceMaps func) {
        LOGGER.log("runBackground called // position " + position);
        MapsData.list.get(position).setFlag(0);
        MapsData.list.get(position).setResultOfCalculation(0);
        FragmentTab2.adapter.notifyDataSetChanged();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                LOGGER.log("run called");
                LOGGER.log("Thread // " + executor.toString());
                int result = func.startMap(map);
                MapsData.list.get(position).setResultOfCalculation(result);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LOGGER.log("runOnUiThread // position " + position + " // result " + result);
                        MapsData.list.get(position).setFlag(1);
                        FragmentTab2.adapter.notifyItemChanged(position);
                    }
                });
            }
        });
    }

    public void doTask() {
        LOGGER.log("doTask called");
        LOGGER.log("quantity of CPU " + core);
        runBackground(0, treeMap, MapsUtil::add);
        runBackground(1, hashMap, MapsUtil::add);

        runBackground(2, treeMap, MapsUtil::search);
        runBackground(3, hashMap, MapsUtil::search);

        runBackground(4, treeMap, MapsUtil::remove);
        runBackground(5, hashMap, MapsUtil::remove);



    }
}

