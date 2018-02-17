package com.example.alex.collectionsandmap.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alex.collectionsandmap.R;
import com.example.alex.collectionsandmap.adapter.CollectionsAdapter;
import com.example.alex.collectionsandmap.model.CollectionsData;
import com.example.alex.collectionsandmap.utils.Logger;

public class FragmentTab1 extends Fragment{

    private static Logger LOGGER = new Logger(FragmentTab1.class);
    public static CollectionsAdapter adapter;
    CollectionsData collections = new CollectionsData();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView collectionsRecycler = (RecyclerView) inflater.inflate
                (R.layout.fragment_tab1, container, false);
        LOGGER.log("onCreateView");

        if (CollectionsData.list.size() == 0) {
            collections.addItemsInList();
        }

        adapter = new CollectionsAdapter(CollectionsData.list);
        collectionsRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        collectionsRecycler.setLayoutManager(layoutManager);

        return collectionsRecycler;
    }
}



