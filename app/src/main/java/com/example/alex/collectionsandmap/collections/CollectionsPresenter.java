package com.example.alex.collectionsandmap.collections;

import com.example.alex.collectionsandmap.dagger.AppInject;
import com.example.alex.collectionsandmap.dataCollections.CollectionsRepository;
import com.example.alex.collectionsandmap.dataCollections.executor.ExecutorCollection;
import com.example.alex.collectionsandmap.dataCollections.executor.ExecutorCollectionCallback;
import com.example.alex.collectionsandmap.dataCollections.ICollectionsProcessor;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.inject.Inject;

public class CollectionsPresenter implements CollectionsContract.Presenter, CollectionsRepository, ExecutorCollectionCallback {

    private static Logger LOGGER = new Logger(CollectionsPresenter.class);

    @Inject CollectionsContract.View view;

    @Inject CollectionsRepository repository;

    @Inject ICollectionsProcessor processor;

    // TODO: 09.04.2018 Can't inject with callback
    private ExecutorCollection executor = new ExecutorCollection(this);

    @Inject
    public CollectionsPresenter() {
        AppInject.getComponent().inject(this);
    }

    @Override
    public void calculate() {
        LOGGER.log("calculate");

//        view.onCalculationStarted();todo crash because no Context

        executor.doCalculateBackground(0, new ArrayList(), processor::addToStart);
        executor.doCalculateBackground(1, new LinkedList<>(), processor::addToStart);
        executor.doCalculateBackground(2, new CopyOnWriteArrayList(), processor::addToStart);

        executor.doCalculateBackground(3, new ArrayList<>(), processor::addToMiddle);
        executor.doCalculateBackground(4, new LinkedList<>(), processor::addToMiddle);
        executor.doCalculateBackground(5, new CopyOnWriteArrayList(), processor::addToMiddle);

        executor.doCalculateBackground(6, new ArrayList<>(), processor::addToEnd);
        executor.doCalculateBackground(7, new LinkedList<>(), processor::addToEnd);
        executor.doCalculateBackground(8, new CopyOnWriteArrayList(), processor::addToEnd);

        executor.doCalculateBackground(9, new ArrayList<>(), processor::search);
        executor.doCalculateBackground(10, new LinkedList<>(), processor::search);
        executor.doCalculateBackground(11, new CopyOnWriteArrayList(), processor::search);

        executor.doCalculateBackground(12, new ArrayList<>(), processor::removeStart);
        executor.doCalculateBackground(13, new LinkedList<>(), processor::removeStart);
        executor.doCalculateBackground(14, new CopyOnWriteArrayList(), processor::removeStart);

        executor.doCalculateBackground(15, new ArrayList<>(), processor::removeMiddle);
        executor.doCalculateBackground(16, new LinkedList<>(), processor::removeMiddle);
        executor.doCalculateBackground(17, new CopyOnWriteArrayList(), processor::removeMiddle);

        executor.doCalculateBackground(18, new ArrayList<>(), processor::removeEnd);
        executor.doCalculateBackground(19, new LinkedList<>(), processor::removeEnd);
        executor.doCalculateBackground(20, new CopyOnWriteArrayList(), processor::removeEnd);
    }

    @Override
    public void updateAdapterItem(int position) {
        view.updateAdapter();
    }

    @Override
    public void responseShowProgress(int position) {
        LOGGER.log("response " + position);
        view.showProgressBar(position);
    }

    @Override
    public void responseHideProgress(int position) {
        LOGGER.log("response " + position);
        view.hideProgressBar(position);
    }

    //MODEL
    @Override
    public void createData() {
        LOGGER.log("createData");
        repository.createData();
        view.updateAdapter();
    }
}
