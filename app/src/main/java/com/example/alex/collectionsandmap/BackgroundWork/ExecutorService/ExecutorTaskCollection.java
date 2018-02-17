package com.example.alex.collectionsandmap.BackgroundWork.ExecutorService;

import android.support.v7.app.AppCompatActivity;

import com.example.alex.collectionsandmap.model.CollectionsData;
import com.example.alex.collectionsandmap.model.CollectionsUtil;
import com.example.alex.collectionsandmap.model.DataInterfaceCollections;
import com.example.alex.collectionsandmap.utils.Logger;
import com.example.alex.collectionsandmap.view.FragmentTab1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTaskCollection extends AppCompatActivity {

    private static Logger LOGGER = new Logger(ExecutorTaskCollection.class);
    private ArrayList <Integer> al = new ArrayList<>();
    private LinkedList <Integer> ll = new LinkedList<>();
    private CopyOnWriteArrayList <Integer> cow = new CopyOnWriteArrayList<>();

    int core = Runtime.getRuntime().availableProcessors();

    ExecutorService executor = Executors.newFixedThreadPool(core*2);


    void runBackground(final int position, final List list, DataInterfaceCollections func){
        LOGGER.log("runBackground called // position " + position);
        CollectionsData.list.get(position).setFlag(0);
        CollectionsData.list.get(position).setResultOfCalculation(0);
        FragmentTab1.adapter.notifyDataSetChanged();
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
                        CollectionsData.list.get(position).setFlag(1);
                        FragmentTab1.adapter.notifyItemChanged(position);
                    }
                });
            }
        });
    }

    public void doTask(){
        LOGGER.log("doTask called");
        LOGGER.log("quantity of CPU " + core);
        runBackground(0,al, CollectionsUtil::addToStart);
        runBackground(1,ll, CollectionsUtil::addToStart);
        runBackground(2,cow, CollectionsUtil::addToStart);

        runBackground(3,al, CollectionsUtil::addToMiddle);
        runBackground(4,ll, CollectionsUtil::addToMiddle);
        runBackground(5,cow, CollectionsUtil::addToMiddle);

        runBackground(6,al, CollectionsUtil::addToEnd);
        runBackground(7,ll, CollectionsUtil::addToEnd);
        runBackground(8,cow, CollectionsUtil::addToEnd);

        runBackground(9,al, CollectionsUtil::search);
        runBackground(10,ll, CollectionsUtil::search);
        runBackground(11,cow, CollectionsUtil::search);

        runBackground(12,al, CollectionsUtil::removeStart);
        runBackground(13,ll, CollectionsUtil::removeStart);
        runBackground(14,cow, CollectionsUtil::removeStart);

        runBackground(15,al, CollectionsUtil::removeMiddle);
        runBackground(16,ll, CollectionsUtil::removeMiddle);
        runBackground(17,cow, CollectionsUtil::removeMiddle);

        runBackground(18,al, CollectionsUtil::removeEnd);
        runBackground(19,ll, CollectionsUtil::removeEnd);
        runBackground(20,cow, CollectionsUtil::removeEnd);
    }
}
