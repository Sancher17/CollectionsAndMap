package com.example.alex.collectionsandmap.collections;

import com.example.alex.collectionsandmap.dataCollections.executor.ExecutorCollection;
import com.example.alex.collectionsandmap.dataCollections.executor.ExecutorCollectionCallback;
import com.example.alex.collectionsandmap.utils.Logger;

public class CollectionsPresenter implements CollectionsContract.Presenter, ExecutorCollectionCallback {

    private static Logger LOGGER = new Logger(CollectionsPresenter.class);

    private CollectionsContract.View view;
    private ExecutorCollection executor;

    private static CollectionsPresenter instance = null;

    public static CollectionsPresenter getInstance() {
        if (instance == null) {
            return instance = new CollectionsPresenter();
        }
        return instance;
    }

    @Override
    public void attachView(CollectionsContract.View view){
        this.view = view;
    }

    @Override
    public void detachView() {
        LOGGER.log("detachView");
        view = null;
    }

    @Override
    public void calculate() {
        LOGGER.log("calculate");
        executor = new ExecutorCollection(this);
        executor.startCalculation();
        view.onCalculationStarted();
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
}
