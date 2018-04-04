package com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService;

import com.example.alex.collectionsandmap.adapters.CollectionsAdapter;
import com.example.alex.collectionsandmap.dataCollections.CollectionsData;
import com.example.alex.collectionsandmap.model.CollectionsProcessor;
import com.example.alex.collectionsandmap.model.ICollectionsProcessor;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;



public class ExecutorCollection {

    private static Logger LOGGER = new Logger(ExecutorCollection.class);
    private int core = Runtime.getRuntime().availableProcessors();
    private ExecutorService executor = Executors.newFixedThreadPool(core+1);

    // TODO: 01.04.2018 callback
    private ExecutorCollectionCallback callback;

    // TODO: 01.04.2018 callbcak - new constructor
    public ExecutorCollection(ExecutorCollectionCallback callback){
        this.callback = callback;
    }

    @Inject
    public ExecutorCollection() {
    }

    public void runCalculate(){
//        doCalculateBackground(0, new ArrayList(), processor::addToStart);
//        doCalculateBackground(1, new LinkedList<>(), processor::addToStart);
//        doCalculateBackground(2, new CopyOnWriteArrayList(), processor::addToStart);
//
//        doCalculateBackground(3, new ArrayList<>(), processor::addToMiddle);
//        doCalculateBackground(4, new LinkedList<>(), processor::addToMiddle);
//        doCalculateBackground(5, new CopyOnWriteArrayList(), processor::addToMiddle);
//
//        doCalculateBackground(6, new ArrayList<>(), processor::addToEnd);
//        doCalculateBackground(7, new LinkedList<>(), processor::addToEnd);
//        doCalculateBackground(8, new CopyOnWriteArrayList(), processor::addToEnd);
//
//        doCalculateBackground(9, new ArrayList<>(), processor::search);
//        doCalculateBackground(10, new LinkedList<>(), processor::search);
//        doCalculateBackground(11, new CopyOnWriteArrayList(), processor::search);
//
//        doCalculateBackground(12, new ArrayList<>(), processor::removeStart);
//        doCalculateBackground(13, new LinkedList<>(), processor::removeStart);
//        doCalculateBackground(14, new CopyOnWriteArrayList(), processor::removeStart);
//
//        doCalculateBackground(15, new ArrayList<>(), processor::removeMiddle);
//        doCalculateBackground(16, new LinkedList<>(), processor::removeMiddle);
//        doCalculateBackground(17, new CopyOnWriteArrayList(), processor::removeMiddle);
//
//        doCalculateBackground(18, new ArrayList<>(), processor::removeEnd);
//        doCalculateBackground(19, new LinkedList<>(), processor::removeEnd);
//        doCalculateBackground(20, new CopyOnWriteArrayList(), processor::removeEnd);
    }


    public void doCalculateBackground(final int position, List list, ICollections func){
        LOGGER.log("doCalculateBackground // position " + position);
        CollectionsData.list.get(position).setProgressBar(true);
        executor.submit(new Runnable() {
            @Override
            public void run() {
//                LOGGER.log("Thread // "+ executor.toString());
                int result = func.start(list);
                CollectionsData.list.get(position).setResultOfCalculation(result);
//                CollectionsData.list.get(position).setProgressBar(false);
                callback.response(position);
            }
        });
    }
}

//LOGGER.log(" action " + CollectionsData.list.get(0).getAction()
//        + "\n name " + CollectionsData.list.get(0).getName()
//        + "\n progress bar " + CollectionsData.list.get(0).getProgressBar()
//        + "\n result " + CollectionsData.list.get(0).getResultOfCalculation());

// TODO: 01.04.2018 old decision
//runOnUiThread(new Runnable() {
//    @Override
//    public void run() {
//        LOGGER.log("runOnUiThread // position " + position + " // result " + result);
//        CollectionsData.list.get(position).setProgressBar(false);
////                        iCollectionsPresenter.updateAdapterItem(position);
//        // TODO: 01.04.2018 callback
//        callback.responce(position);
//    }
//});
