package com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService;

import android.os.Handler;
import android.os.Looper;

import com.example.alex.collectionsandmap.dataCollections.CollectionsData;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class ExecutorCollection {

    private static Logger LOGGER = new Logger(ExecutorCollection.class);
    private int core = Runtime.getRuntime().availableProcessors();
    private ExecutorService executor = Executors.newFixedThreadPool(core+1);

    private ExecutorCollectionCallback callback;

    @Inject
    public ExecutorCollection(ExecutorCollectionCallback callback){
        this.callback = callback;
    }

    public void doCalculateBackground(final int position, List list, ICollections func){
        LOGGER.log("doCalculateBackground // position " + position);
        LOGGER.log("run 0 " + Thread.currentThread());
        callback.responseShowProgress(position);
        executor.submit(() -> {
            LOGGER.log("run 1 " + Thread.currentThread());
            int result = func.start(list);
            new Handler(Looper.getMainLooper()).post(() -> {
                LOGGER.log("run 3 " + Thread.currentThread());
                CollectionsData.list.get(position).setResultOfCalculation(result);
                callback.responseHideProgress(position);
            });
        });
    }
}