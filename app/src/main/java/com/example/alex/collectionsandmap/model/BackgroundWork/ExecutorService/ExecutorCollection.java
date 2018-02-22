package com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService;

import android.support.v7.app.AppCompatActivity;

import com.example.alex.collectionsandmap.presenter.CollectionsPresenter;
import com.example.alex.collectionsandmap.presenter.ICollectionsPresenter;
import com.example.alex.collectionsandmap.repository.CollectionsData;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorCollection extends AppCompatActivity {

    private static Logger LOGGER = new Logger(ExecutorCollection.class);
    private int core = Runtime.getRuntime().availableProcessors();
    private ExecutorService executor = Executors.newFixedThreadPool(core+1);

    ICollectionsPresenter iCollectionsPresenter;

    public void runBackground(final int position, List list, ICollections func){
        LOGGER.log("runBackground called // position " + position);
        iCollectionsPresenter = new CollectionsPresenter();
        CollectionsData.list.get(position).setProgressBar(true);
        CollectionsData.list.get(position).setResultOfCalculation(0);
        iCollectionsPresenter.updateAdapterItem(position);
        executor.submit(new Runnable() {
            @Override
            public void run() {
                LOGGER.log("run called");
                LOGGER.log("Thread // "+ executor.toString());
                int result = func.start(list);
                CollectionsData.list.get(position).setResultOfCalculation(result);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LOGGER.log("runOnUiThread // position " + position + " // result " + result);
                        CollectionsData.list.get(position).setProgressBar(false);
                        iCollectionsPresenter.updateAdapterItem(position);
                    }
                });
            }
        });
    }
}
