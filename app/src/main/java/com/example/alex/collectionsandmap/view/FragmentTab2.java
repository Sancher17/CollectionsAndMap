package com.example.alex.collectionsandmap.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alex.collectionsandmap.R;
import com.example.alex.collectionsandmap.adapter.MapsAdapter;
import com.example.alex.collectionsandmap.model.MapsData;
import com.example.alex.collectionsandmap.utils.Logger;

public class FragmentTab2 extends Fragment {

    private static Logger LOGGER = new Logger(FragmentTab2.class);
    public static MapsAdapter adapter;
    MapsData maps = new MapsData();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView collectionsRecycler = (RecyclerView) inflater.inflate
                (R.layout.fragment_tab1, container, false);
        LOGGER.log("onCreateView");

        if (MapsData.list.size() == 0) {
            maps.addItemsInList();
        }

        adapter = new MapsAdapter(MapsData.list);
        collectionsRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        collectionsRecycler.setLayoutManager(layoutManager);

        return collectionsRecycler;
    }
}
