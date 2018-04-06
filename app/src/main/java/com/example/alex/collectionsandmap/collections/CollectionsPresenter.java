package com.example.alex.collectionsandmap.collections;

import com.example.alex.collectionsandmap.BasePresenterDima;
import com.example.alex.collectionsandmap.dagger.AppInject;
import com.example.alex.collectionsandmap.dataCollections.CollectionsData;
import com.example.alex.collectionsandmap.dataCollections.CollectionsRepository;
import com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService.ExecutorCollection;
import com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService.ExecutorCollectionCallback;
import com.example.alex.collectionsandmap.model.CollectionsProcessor;
import com.example.alex.collectionsandmap.model.ICollectionsProcessor;
import com.example.alex.collectionsandmap.presenters.BasePresenter;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.inject.Inject;

public class CollectionsPresenter extends BasePresenterDima<CollectionsContract.View> implements CollectionsContract.Presenter, CollectionsRepository, ExecutorCollectionCallback {

    private static Logger LOGGER = new Logger(CollectionsPresenter.class);

    //    private ExecutorCollection executor; //dagger
    private ExecutorCollection executor = new ExecutorCollection(this);
    private CollectionsRepository repository = new CollectionsData();
    private CollectionsContract.View view;
    private ICollectionsProcessor processor = new CollectionsProcessor();

    @Inject
    public CollectionsPresenter(CollectionsContract.View view) {
        this.view = view;
    }

    @Override
    public void attachView(CollectionsContract.View view) {
       super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }


    @Override
    public void calculate() {
        LOGGER.log("calculate");

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

    /**
     * MODEL
     */
    @Override
    public void createData() {
        LOGGER.log("createData");
        repository.createData();
        view.updateAdapter();
    }
}
