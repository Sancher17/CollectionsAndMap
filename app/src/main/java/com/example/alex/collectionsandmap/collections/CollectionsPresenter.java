package com.example.alex.collectionsandmap.collections;

import com.example.alex.collectionsandmap.arch.PresenterBase;
import com.example.alex.collectionsandmap.dataCollections.executor.ExecutorCollection;
import com.example.alex.collectionsandmap.dataCollections.executor.ExecutorCollectionCallback;
import com.example.alex.collectionsandmap.constants.Constants;
import com.example.alex.collectionsandmap.dataCollections.executor.LifecycleExecutor;
import com.example.alex.collectionsandmap.utils.Logger;

public class CollectionsPresenter extends PresenterBase<CollectionsContract.View> implements CollectionsContract.Presenter, ExecutorCollectionCallback {

    private static Logger LOGGER = new Logger(CollectionsPresenter.class);

    private  LifecycleExecutor executor;


    @Override
    public void attachView(CollectionsContract.View view){
       super.attachView(view);
    }

    @Override
    public void detachView() {
        LOGGER.log("detachView");
        super.detachView();
    }

    @Override
    public void calculate() {
        LOGGER.log("calculate");
        executor = new ExecutorCollection(this);
        if (Constants.COUNT_OF_OPERATIONS_COLLECTIONS == 21){
            executor.startCalculation();
            getView().showCalculationStarted();
        }else {
            getView().showCalculationIsStillWorking();
        }
    }

    @Override
    public void stopСalculation(){
        LOGGER.log("stopСalculation");
        if (executor != null) {
            executor.stopCalculation();
            getView().stopAllProgressBars();
            getView().updateAdapter();
            getView().showWait();
        }else {
            getView().showCalculationNotStarted();
        }
    }

    @Override
    public void responseShowProgress(int position) {
//        LOGGER.log("response " + position);
        getView().showProgressBar(position);
    }

    @Override
    public void responseHideProgress(int position) {
        LOGGER.log("response " + position);
        getView().hideProgressBar(position);
        checkCountOfOperations();
    }


    @Override
    public void calculationStopped(){
        getView().showCalculationStopped();
        executor = null;
    }

    void checkCountOfOperations(){
        if (Constants.COUNT_OF_OPERATIONS_COLLECTIONS == 0 ){
            getView().showCalculationFinished();
            Constants.COUNT_OF_OPERATIONS_COLLECTIONS = 21;
        }

    }
}
