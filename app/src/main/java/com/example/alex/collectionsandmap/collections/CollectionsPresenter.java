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


    // TODO: 09.04.2018 Can't inject with callback
    private ExecutorCollection executor = new ExecutorCollection(this);

    @Inject
    public CollectionsPresenter() {
        AppInject.getComponent().inject(this);
    }

    @Override
    public void calculate() {
        LOGGER.log("calculate");
        executor.startCalculation();

//        view.onCalculationStarted();//todo crash because no Context
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
