package com.example.alex.collectionsandmap.maps;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alex.collectionsandmap.R;
import com.example.alex.collectionsandmap.adapters.MapsAdapter;
import com.example.alex.collectionsandmap.model.repository.MapsData;
import com.example.alex.collectionsandmap.utils.Logger;

public class MapsFragment extends Fragment implements MapsContract.View {

    private static Logger LOGGER = new Logger(MapsFragment.class);
    public static MapsAdapter adapter;
    MapsData maps = new MapsData();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tab2, container, false);

        RecyclerView collectionsRecycler = root.findViewById(R.id.tab2_recycler);


        adapter = new MapsAdapter(MapsData.list);
        collectionsRecycler.setAdapter(adapter);
        collectionsRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return collectionsRecycler;
    }

    @Override
    public void onStartCalculation() {

    }

    @Override
    public void onCalculationFinished() {

    }

    @Override
    public void onDataIsStillLoadingError() {

    }

    @Override
    public void updateAdapter() {

    }

    @Override
    public void updateItemAdapter(int position) {

    }

    @Override
    public void showProgressBar(int position) {

    }

    @Override
    public void hideProgressBar(int position) {

    }

    @Override
    public void onCalculationStarted() {

    }

    @Override
    public void onButtonClick() {

    }

    @Override
    public void showError() {

    }
}
