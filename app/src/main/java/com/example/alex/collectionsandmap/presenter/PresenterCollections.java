package com.example.alex.collectionsandmap.presenter;

import android.content.Context;

import com.example.alex.collectionsandmap.BackgroundTask;
import com.example.alex.collectionsandmap.MyCallback;
import com.example.alex.collectionsandmap.MyClass;
import com.example.alex.collectionsandmap.MyTask;
import com.example.alex.collectionsandmap.adapter.CollectionsAdapter;
import com.example.alex.collectionsandmap.model.CollectionsData;
import com.example.alex.collectionsandmap.model.MyData;
import com.example.alex.collectionsandmap.utils.Logger;
import com.example.alex.collectionsandmap.view.FragmentTab1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class PresenterCollections {

    /****/
    private BackgroundTask backgroundTask = new BackgroundTask();
    private MyClass myClass = new MyClass();
    /****/

    public static boolean PROGRESS = false;
    public static int INPUT_NUMBER = 100000;
    private static Logger LOGGER = new Logger(PresenterCollections.class);

//    private CollectionsData collections = new CollectionsData();

    private ArrayList al = new ArrayList();
    private LinkedList ll = new LinkedList();
    private CopyOnWriteArrayList cowal = new CopyOnWriteArrayList();

    private MyData myData = new MyData();


    public void calculate() {
        LOGGER.log("calculate called");
//        LOGGER.log("flag " + CollectionsData.list.get(0).getFlag());
//        CollectionsData.list.get(0).setFlag(0);
//        CollectionsData.list.get(1).setFlag(0);
//        CollectionsData.list.get(2).setFlag(0);
//        LOGGER.log("flag " + CollectionsData.list.get(0).getFlag());
//        FragmentTab1.adapter.notifyDataSetChanged();

        /** решение с AsyncTysk все работатет start*/
//        myTask = new MyTask();
//        myTask.execute();
        /**end*/

//        CollectionsData.list.get(0).setFlag(0);
        /**пробую ExecutorService 12.02. start*/
//        ExecutorService executor = Executors.newSingleThreadExecutor();

        /**Runnable без возврата результата*/
//        Future<?> future = executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                CollectionsData.list.get(0).setResultOfCalculation(myData.addToStart(al));
//                CollectionsData.list.get(1).setResultOfCalculation(myData.addToStart(ll));
//                CollectionsData.list.get(2).setResultOfCalculation(myData.addToStart(cowal));
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

        /**Callable с возвратом результата*/
//        Future<Object> future = executor.submit(new Callable<Object>() {
//            @Override
//            public Object call() throws Exception {
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
//        CollectionsData.list.get(0).setFlag(1);
//        FragmentTab1.adapter.notifyDataSetChanged();

//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                CollectionsData.list.get(0).setResultOfCalculation(myData.addToStart(al));
//            }
//        });

//        FragmentTab1.adapter.notifyDataSetChanged();
        /**end*/
//        /*****************************/
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                LOGGER.log("run started" );
//                CollectionsData.list.get(0).setResultOfCalculation(myData.addToStart(al));
//                LOGGER.log("run result" );
//
//            }
//        };
//        Thread t = new Thread(runnable);
//        t.start();
//
//        handler = new Handler() {
//            @Override
//            public void publish(LogRecord logRecord) {
//
//            }
//
//            @Override
//            public void flush() {
//
//            }
//
//            @Override
//            public void close() throws SecurityException {
//
//            }
//        };
//

        /****************************/

        /**Решение с Callback*/
//        LOGGER.log("BEFORE registerCallback() ");
//        backgroundTask.registerCallback(myClass);
//        LOGGER.log("BEFORE doTask() ");
        backgroundTask.doTask1();
        /**end*/


    }
}
