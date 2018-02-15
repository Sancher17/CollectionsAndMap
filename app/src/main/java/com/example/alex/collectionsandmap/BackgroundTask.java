package com.example.alex.collectionsandmap;

import android.support.v7.app.AppCompatActivity;

import com.example.alex.collectionsandmap.model.CollectionsData;
import com.example.alex.collectionsandmap.model.MyData;
import com.example.alex.collectionsandmap.presenter.PresenterCollections;
import com.example.alex.collectionsandmap.utils.Logger;
import com.example.alex.collectionsandmap.view.FragmentTab1;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@EActivity(R.layout.fragment_tab1)
public class BackgroundTask extends AppCompatActivity {
    private static Logger LOGGER = new Logger(BackgroundTask.class);

    private MyCallback callback;
    private MyData myData = new MyData();
    private ArrayList al = new ArrayList();

    public void registerCallback(MyCallback callback) {
        LOGGER.log("registerCallback called");
        this.callback = callback;
    }


    public void doTask() {
        LOGGER.log("doTask called");
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(new Runnable() {
            @Override
            public void run() {
                LOGGER.log("run called");
                CollectionsData.list.get(0).setFlag(1);
                CollectionsData.list.get(0).setResultOfCalculation(myData.addToStart(al));
                LOGGER.log(String.valueOf(CollectionsData.list.get(0).getResultOfCalculation()));
                LOGGER.log("BEFORE callbackCall() ");
//                callback.callbackCall();

            }
        });



//        Future<Object> future = executor.submit(new Callable<Object>() {
//            @Override
//            public Object call() throws Exception {
//                LOGGER.log("call called");
//                CollectionsData.list.get(0).setResultOfCalculation(myData.addToStart(al));
//                return null;
//            }
//        });

//        try {
//
//            Object result = future.get();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }


    /** Anatation**/


    public void doTask1(){
//        CollectionsData.list.get(0).setFlag(0);
        doAsync();

    }

    @Background
    void doAsync(){
//        LOGGER.log("run called");
        CollectionsData.list.get(0).setResultOfCalculation(myData.addToStart(al));
//        LOGGER.log(String.valueOf(CollectionsData.list.get(0).getResultOfCalculation()));
//        LOGGER.log("BEFORE callbackCall() ");
        showResult();
    }

    @UiThread
    void showResult(){
//        CollectionsData.list.get(0).setFlag(0);
        FragmentTab1.adapter.notifyItemChanged(0);
    }




    /***/





}
