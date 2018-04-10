package com.example.alex.collectionsandmap.dataMaps.executor;


import android.support.v7.app.AppCompatActivity;

import com.example.alex.collectionsandmap.dataCollections.executor.ExecutorCollection;
import com.example.alex.collectionsandmap.dataMaps.MapsData;
import com.example.alex.collectionsandmap.utils.Logger;
import com.example.alex.collectionsandmap.maps.MapsFragment;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMap extends AppCompatActivity {

    private static Logger LOGGER = new Logger(ExecutorCollection.class);
    private int core = Runtime.getRuntime().availableProcessors();
    private ExecutorService executor = Executors.newFixedThreadPool(core+1);

    interface CompleteCallback {
        void onComplete();
    }


    public void runBackground(final int position, Map map, IMaps func) {
        LOGGER.log("doCalculateBackground called // position " + position);
        MapsData.list.get(position).setProgressBar(true);
        MapsData.list.get(position).setResultOfCalculation(0);
        MapsFragment.adapter.notifyDataSetChanged();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                LOGGER.log("run called");
                LOGGER.log("Thread // " + executor.toString()+ " // "+ Thread.currentThread().getName());
                int result = func.startMap(map);
                MapsData.list.get(position).setResultOfCalculation(result);
                runOnUiThread(() -> {
                    LOGGER.log("runOnUiThread // position " + position + " // result " + result);
                    MapsData.list.get(position).setProgressBar(false);
                    MapsFragment.adapter.notifyItemChanged(position);
                });
            }
        });
    }
}

