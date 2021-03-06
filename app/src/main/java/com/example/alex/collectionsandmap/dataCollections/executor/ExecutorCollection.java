package com.example.alex.collectionsandmap.dataCollections.executor;

import android.os.Handler;
import android.os.Looper;

import com.example.alex.collectionsandmap.collections.CollectionsAdapter;
import com.example.alex.collectionsandmap.collections.CollectionsPresenter;
import com.example.alex.collectionsandmap.dataCollections.CollectionsProcessor;
import com.example.alex.collectionsandmap.dataCollections.ICollectionsProcessor;
import com.example.alex.collectionsandmap.constants.Constants;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorCollection implements LifecycleExecutor {

    private static Logger LOGGER = new Logger(ExecutorCollection.class);
    private int core = Runtime.getRuntime().availableProcessors();

    private ExecutorService executor = Executors.newFixedThreadPool(core + 1);

    private ExecutorCollectionCallback callback;

    private ICollectionsProcessor processor;

    private CollectionsAdapter adapter = new CollectionsAdapter();

    private CollectionsPresenter presenter;


    public ExecutorCollection(ExecutorCollectionCallback callback) {
        this.callback = callback;
    }

    @Override
    public void startCalculation() {

        processor = new CollectionsProcessor();

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

    public void doCalculateBackground(final int position, List list, ICollections func) {
        LOGGER.log("doCalculateBackground // position " + position);
        LOGGER.log("run 0 " + Thread.currentThread());
        callback.responseShowProgress(position);
        executor.submit(() -> {
            LOGGER.log("run 1 " + Thread.currentThread());
            int result = func.start(list);
            new Handler(Looper.getMainLooper()).post(() -> {
                LOGGER.log("run 3 " + Thread.currentThread());
                adapter.items.get(position).setResultOfCalculation(result);
                Constants.COUNT_OF_OPERATIONS_COLLECTIONS -= 1;
                callback.responseHideProgress(position);
            });
        });
    }

    @Override
    public void stopCalculation() {
        executor.shutdownNow();
        ExecutorService interrupt = Executors.newFixedThreadPool(1);
        interrupt.submit(() -> {
            while (!executor.isTerminated()) {
                try {
                    Thread.sleep(500);
                    LOGGER.log("isTerminated sleep");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            new Handler(Looper.getMainLooper()).post(() -> {
                presenter = new CollectionsPresenter();
                presenter.calculationStopped();
                Constants.COUNT_OF_OPERATIONS_COLLECTIONS = 21;
                LOGGER.log("isTerminated // " + executor.isTerminated());
            });
        });
    }
}
