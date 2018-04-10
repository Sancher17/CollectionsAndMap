package com.example.alex.collectionsandmap.maps;

import com.example.alex.collectionsandmap.dataMaps.executor.ExecutorMap;
import com.example.alex.collectionsandmap.dataMaps.IMapProcessor;
import com.example.alex.collectionsandmap.dataMaps.MapsProcessor;
//import com.example.alex.collectionsandmap.presenters.IMapsPresenter;
import com.example.alex.collectionsandmap.utils.Logger;

class MapsPresenter  {

    private int core = Runtime.getRuntime().availableProcessors();

    private ExecutorMap map = new ExecutorMap();
    private IMapProcessor processor = new MapsProcessor();

//    @Override
//    public void calculate() {
//        LOGGER.log("calculate called");
//        LOGGER.log("quantity of CPU " + core);
//        map.doCalculateBackground(0, new TreeMap(), processor::add);
//        map.doCalculateBackground(1, new HashMap(), processor::add);
//
//        map.doCalculateBackground(2, new TreeMap(), processor::search);
//        map.doCalculateBackground(3, new HashMap(), processor::search);
//
//        map.doCalculateBackground(4, new TreeMap(), processor::remove);
//        map.doCalculateBackground(5, new HashMap(), processor::remove);
//    }
//
//    @Override
//    public void updateAdapterItem(int position) {
//        MapsFragment.adapter.notifyItemChanged(position);
//    }
}
