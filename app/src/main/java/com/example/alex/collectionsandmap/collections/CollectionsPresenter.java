package com.example.alex.collectionsandmap.collections;

import com.example.alex.collectionsandmap.dataCollections.executor.ExecutorCollection;
import com.example.alex.collectionsandmap.dataCollections.executor.ExecutorCollectionCallback;
import com.example.alex.collectionsandmap.constants.Constants;
import com.example.alex.collectionsandmap.dataCollections.executor.LifecycleExecutor;
import com.example.alex.collectionsandmap.utils.Logger;

public class CollectionsPresenter implements CollectionsContract.Presenter, ExecutorCollectionCallback {

    private static Logger LOGGER = new Logger(CollectionsPresenter.class);

    private  CollectionsContract.View view;
    private  LifecycleExecutor executor;

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
        if (Constants.COUNT_OF_OPERATIONS_COLLECTIONS == 21){
            executor.startCalculation();
            view.showCalculationStarted();
        }else {
            view.showCalculationIsStillWorking();
        }
    }

    @Override
    public void stopСalculation(){
        LOGGER.log("stopСalculation");
        if (executor != null) {
            executor.stopCalculation();
            view.stopAllProgressBars();
            view.updateAdapter();
            view.showWait();
        }else {
            view.showCalculationNotStarted();
        }
    }

    @Override
    public void responseShowProgress(int position) {
//        LOGGER.log("response " + position);
        view.showProgressBar(position);
    }

    @Override
    public void responseHideProgress(int position) {
        LOGGER.log("response " + position);
        view.hideProgressBar(position);
        checkCountOfOperations();
    }

    public void calculationStopped(){
        view.showCalculationStopped();
    }

    void checkCountOfOperations(){
        if (Constants.COUNT_OF_OPERATIONS_COLLECTIONS == 0 ){
            view.showCalculationFinished();
            Constants.COUNT_OF_OPERATIONS_COLLECTIONS = 21;
        }

    }
}
