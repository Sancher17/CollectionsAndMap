package com.example.alex.collectionsandmap.presenters;

import com.example.alex.collectionsandmap.utils.Logger;
import com.example.alex.collectionsandmap.view.IView;

import static com.example.alex.collectionsandmap.view.MainActivity.GET_POSITION_TAB;

public class BasePresenter implements IBasePresenter {

    private IView iView;
    private IMapsPresenter iMapsPresenter;
    private ICollectionsPresenter iCollectionsPresenter;

    private static Logger LOGGER = new Logger(BasePresenter.class);

    public BasePresenter(IView iView){
        this.iView = iView;
    }


    public void calculate() {
        LOGGER.log("calculate called");

        if (GET_POSITION_TAB == 0) {
            iCollectionsPresenter = new CollectionsPresenter();
            iCollectionsPresenter.doTask();
        } else {
            iMapsPresenter = new MapsPresenter();
            iMapsPresenter.doTask();
        }
    }

}


/**
 * heap решение с AsyncTysk все работатет startendпробую ExecutorService 12.02. startRunnable без возврата результатаCallable с возвратом результатаendРешение с Callback
 */
//        LOGGER.log("flag " + CollectionsData.list.get(0).getProgressBar());
//        CollectionsData.list.get(0).setProgressBar(0);
//        CollectionsData.list.get(1).setProgressBar(0);
//        CollectionsData.list.get(2).setProgressBar(0);
//        LOGGER.log("flag " + CollectionsData.list.get(0).getProgressBar());
//        FragmentTab1.adapter.notifyDataSetChanged();

/** решение с AsyncTysk все работатет start*/
//        myTask = new MyAsyncTask();
//        myTask.execute();
/**end*/

//        CollectionsData.list.get(0).setProgressBar(0);
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
//        CollectionsData.list.get(0).setProgressBar(1);
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
//        collection.registerCallback(ft1);
//        LOGGER.log("BEFORE doTask() ");
//        collection.doTask();
//        /**end*/

//
//    }
//}
