package com.example.alex.collectionsandmap.presenters;

import com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService.ExecutorCollection;
import com.example.alex.collectionsandmap.model.CollectionsProcessor;
import com.example.alex.collectionsandmap.model.ICollectionsProcessor;
import com.example.alex.collectionsandmap.utils.Logger;
import com.example.alex.collectionsandmap.view.FragmentTab1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsPresenter implements ICollectionsPresenter {

    private static Logger LOGGER = new Logger(ExecutorCollection.class);
    private int core = Runtime.getRuntime().availableProcessors();
    private ExecutorCollection ec = new ExecutorCollection();
    private ICollectionsProcessor processor = new CollectionsProcessor();

    @Override
    public void doTask(){
        LOGGER.log("doTask called");
        LOGGER.log("quantity of CPU " + core);

        ec.runBackground(0, new ArrayList<>(), processor::addToStart);
        ec.runBackground(1, new LinkedList<>(), processor::addToStart);
        ec.runBackground(2, new CopyOnWriteArrayList(), processor::addToStart);

        ec.runBackground(3, new ArrayList<>(), processor::addToMiddle);
        ec.runBackground(4, new LinkedList<>(), processor::addToMiddle);
        ec.runBackground(5, new CopyOnWriteArrayList(), processor::addToMiddle);

        ec.runBackground(6, new ArrayList<>(), processor::addToEnd);
        ec.runBackground(7, new LinkedList<>(), processor::addToEnd);
        ec.runBackground(8, new CopyOnWriteArrayList(), processor::addToEnd);

        ec.runBackground(9, new ArrayList<>(), processor::search);
        ec.runBackground(10, new LinkedList<>(), processor::search);
        ec.runBackground(11, new CopyOnWriteArrayList(), processor::search);

        ec.runBackground(12, new ArrayList<>(), processor::removeStart);
        ec.runBackground(13, new LinkedList<>(), processor::removeStart);
        ec.runBackground(14, new CopyOnWriteArrayList(), processor::removeStart);

        ec.runBackground(15, new ArrayList<>(), processor::removeMiddle);
        ec.runBackground(16, new LinkedList<>(), processor::removeMiddle);
        ec.runBackground(17, new CopyOnWriteArrayList(), processor::removeMiddle);

        ec.runBackground(18, new ArrayList<>(), processor::removeEnd);
        ec.runBackground(19, new LinkedList<>(), processor::removeEnd);
        ec.runBackground(20, new CopyOnWriteArrayList(), processor::removeEnd);
    }

    @Override
    public void updateAdapterItem(int position) {
        FragmentTab1.adapter.notifyItemChanged(position);
    }
}
