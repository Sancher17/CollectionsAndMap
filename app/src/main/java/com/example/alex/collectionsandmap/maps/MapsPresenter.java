package com.example.alex.collectionsandmap.maps;

import com.example.alex.collectionsandmap.model.BackgroundWork.ExecutorService.ExecutorMap;
import com.example.alex.collectionsandmap.model.IMapProcessor;
import com.example.alex.collectionsandmap.model.MapsProcessor;
import com.example.alex.collectionsandmap.presenters.BasePresenter;
//import com.example.alex.collectionsandmap.presenters.IMapsPresenter;
import com.example.alex.collectionsandmap.utils.Logger;

import java.util.HashMap;
import java.util.TreeMap;

class MapsPresenter  {

    private int core = Runtime.getRuntime().availableProcessors();
    private static Logger LOGGER = new Logger(BasePresenter.class);
    private ExecutorMap map = new ExecutorMap();
    private IMapProcessor processor = new MapsProcessor();

//    @Override
//    public void doTask() {
//        LOGGER.log("doTask called");
//        LOGGER.log("quantity of CPU " + core);
//        map.runBackground(0, new TreeMap(), processor::add);
//        map.runBackground(1, new HashMap(), processor::add);
//
//        map.runBackground(2, new TreeMap(), processor::search);
//        map.runBackground(3, new HashMap(), processor::search);
//
//        map.runBackground(4, new TreeMap(), processor::remove);
//        map.runBackground(5, new HashMap(), processor::remove);
//    }
//
//    @Override
//    public void updateAdapterItem(int position) {
//        MapsFragmentTab.adapter.notifyItemChanged(position);
//    }
}
