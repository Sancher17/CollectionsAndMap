package com.example.alex.collectionsandmap.collections;

import com.example.alex.collectionsandmap.dagger.AppInject;
import com.example.alex.collectionsandmap.dataCollections.CollectionsData;
import com.example.alex.collectionsandmap.dataCollections.CollectionsRepository;
import com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService.ExecutorCollection;
import com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService.ExecutorCollectionCallback;
import com.example.alex.collectionsandmap.model.CollectionsProcessor;
import com.example.alex.collectionsandmap.model.ICollectionsProcessor;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.ArrayList;

public class CollectionsPresenter implements CollectionsContract.Presenter,
        CollectionsRepository, ExecutorCollectionCallback {

    private static Logger LOGGER = new Logger(CollectionsPresenter.class);

//    private ExecutorCollection executor; //dagger
    private ExecutorCollection executor;
    private CollectionsRepository repository;
    private CollectionsContract.View view;
    private ICollectionsProcessor processor = new CollectionsProcessor();

    public CollectionsPresenter(CollectionsContract.View view){
        this.view = view;
//        executor = AppInject.getComponent().getExecutorCollection();//dagger
        executor = new ExecutorCollection(this);
        repository = new CollectionsData();
    }

    @Override
    public void calculate(){
        LOGGER.log("calculate");
        view.showProgressBar(0);
        executor.doCalculateBackground(0, new ArrayList(), processor::addToStart);


    }

    @Override
    public void updateAdapterItem(int position) {
        view.updateAdapter();
    }

    /** MODEL */
    @Override
    public void createData(){
        LOGGER.log("createData");
        repository.createData();
        view.updateAdapter();
    }

    @Override
    public void response(int position) {
        LOGGER.log("response " + position);
        view.hideProgressBar(position);
        view.updateItemAdapter(position);
    }
}
