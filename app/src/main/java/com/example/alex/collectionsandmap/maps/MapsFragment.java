package com.example.alex.collectionsandmap.maps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alex.collectionsandmap.R;
import com.example.alex.collectionsandmap.dataMaps.MapsData;
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
    public void showCalculationFinished() {

    }

    @Override
    public void showCalculationIsStillWorking() {

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
    public void showCalculationStarted() {

    }

    @Override
    public void showCalculationStopped() {

    }

    @Override
    public void stopAllProgressBars() {

    }

    @Override
    public void showWait() {

    }

    @Override
    public void showCalculationNotStarted() {

    }

    @Override
    public void onButtonClick() {

    }

    @Override
    public void showError() {

    }
}
