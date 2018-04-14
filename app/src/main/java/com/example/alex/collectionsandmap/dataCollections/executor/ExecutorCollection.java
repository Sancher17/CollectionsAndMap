package com.example.alex.collectionsandmap.dataCollections.executor;

import android.os.Handler;
import android.os.Looper;

import com.example.alex.collectionsandmap.dataCollections.CollectionsData;
import com.example.alex.collectionsandmap.dataCollections.CollectionsProcessor;
import com.example.alex.collectionsandmap.dataCollections.ICollectionsProcessor;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class ExecutorCollection implements LifecycleExecutor {

    private static Logger LOGGER = new Logger(ExecutorCollection.class);
    private int core = Runtime.getRuntime().availableProcessors();
    private ExecutorService executor = Executors.newFixedThreadPool(core+1);
    private final CountDownLatch countDownLatch;

    private ExecutorCollectionCallback callback;

    private ICollectionsProcessor processor = new CollectionsProcessor();

    @Inject
    public ExecutorCollection(ExecutorCollectionCallback callback){
        this.callback = callback;
        countDownLatch = null;
    }

    public void startCalculation(){
        doCalculateBackground(0, new ArrayList(), processor::addToStart);
        doCalculateBackground(1, new LinkedList(), processor::addToStart);
        doCalculateBackground(2, new CopyOnWriteArrayList(), processor::addToStart);

        doCalculateBackground(3, new ArrayList(), processor::addToMiddle);
        doCalculateBackground(4, new LinkedList(), processor::addToMiddle);
        doCalculateBackground(5, new CopyOnWriteArrayList(), processor::addToMiddle);

        doCalculateBackground(6, new ArrayList(), processor::addToEnd);
        doCalculateBackground(7, new LinkedList(), processor::addToEnd);
        doCalculateBackground(8, new CopyOnWriteArrayList(), processor::addToEnd);

        doCalculateBackground(9, new ArrayList(), processor::search);
        doCalculateBackground(10, new LinkedList(), processor::search);
        doCalculateBackground(11, new CopyOnWriteArrayList(), processor::search);

        doCalculateBackground(12, new ArrayList(), processor::removeStart);
        doCalculateBackground(13, new LinkedList(), processor::removeStart);
        doCalculateBackground(14, new CopyOnWriteArrayList(), processor::removeStart);

        doCalculateBackground(15, new ArrayList(), processor::removeMiddle);
        doCalculateBackground(16, new LinkedList(), processor::removeMiddle);
        doCalculateBackground(17, new CopyOnWriteArrayList(), processor::removeMiddle);

        doCalculateBackground(18, new ArrayList(), processor::removeEnd);
        doCalculateBackground(19, new LinkedList(), processor::removeEnd);
        doCalculateBackground(20, new CopyOnWriteArrayList(), processor::removeEnd);

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



    @Override
    public void start() {

    }

    @Override
    public void stop() {
        int rest = executor.shutdownNow().size();
        for (int i = 0; i < rest; i++) {
            countDownLatch.countDown();
        }

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}