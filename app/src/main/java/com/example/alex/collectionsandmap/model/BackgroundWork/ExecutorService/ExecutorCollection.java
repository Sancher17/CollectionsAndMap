package com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService;

import android.support.v7.app.AppCompatActivity;

import com.example.alex.collectionsandmap.model.CollectionsProcessor;
import com.example.alex.collectionsandmap.repository.CollectionsData;
import com.example.alex.collectionsandmap.model.ICollections;
import com.example.alex.collectionsandmap.utils.Logger;
import com.example.alex.collectionsandmap.view.FragmentTab1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorCollection extends AppCompatActivity {

    private static Logger LOGGER = new Logger(ExecutorCollection.class);
    private ArrayList <Integer> al = new ArrayList<>();
    private LinkedList <Integer> ll = new LinkedList<>();
    private CopyOnWriteArrayList <Integer> cow = new CopyOnWriteArrayList<>();

    int core = Runtime.getRuntime().availableProcessors();

    ExecutorService executor = Executors.newFixedThreadPool(core+1);


    void runBackground(final int position, final List list, ICollections func){
        LOGGER.log("runBackground called // position " + position);
        CollectionsData.list.get(position).setProgressBar(true);
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
                        CollectionsData.list.get(position).setProgressBar(false);
                        FragmentTab1.adapter.notifyItemChanged(position);
                    }
                });
            }
        });
    }

    public void doTask(){
        LOGGER.log("doTask called");
        LOGGER.log("quantity of CPU " + core);
        runBackground(0,al, CollectionsProcessor::addToStart);
        runBackground(1,ll, CollectionsProcessor::addToStart);
        runBackground(2,cow, CollectionsProcessor::addToStart);

        runBackground(3,al, CollectionsProcessor::addToMiddle);
        runBackground(4,ll, CollectionsProcessor::addToMiddle);
        runBackground(5,cow, CollectionsProcessor::addToMiddle);

        runBackground(6,al, CollectionsProcessor::addToEnd);
        runBackground(7,ll, CollectionsProcessor::addToEnd);
        runBackground(8,cow, CollectionsProcessor::addToEnd);

        runBackground(9,al, CollectionsProcessor::search);
        runBackground(10,ll, CollectionsProcessor::search);
        runBackground(11,cow, CollectionsProcessor::search);

        runBackground(12,al, CollectionsProcessor::removeStart);
        runBackground(13,ll, CollectionsProcessor::removeStart);
        runBackground(14,cow, CollectionsProcessor::removeStart);

        runBackground(15,al, CollectionsProcessor::removeMiddle);
        runBackground(16,ll, CollectionsProcessor::removeMiddle);
        runBackground(17,cow, CollectionsProcessor::removeMiddle);

        runBackground(18,al, CollectionsProcessor::removeEnd);
        runBackground(19,ll, CollectionsProcessor::removeEnd);
        runBackground(20,cow, CollectionsProcessor::removeEnd);
    }
}
