package com.example.alex.collectionsandmap.collections;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alex.collectionsandmap.R;
import com.example.alex.collectionsandmap.adapters.CollectionsAdapter;
import com.example.alex.collectionsandmap.dagger.AppInject;
import com.example.alex.collectionsandmap.dataCollections.CollectionsData;
import com.example.alex.collectionsandmap.utils.Logger;

import javax.inject.Inject;

public final class CollectionsFragment extends Fragment implements CollectionsContract.View {

    private static Logger LOGGER = new Logger(CollectionsFragment.class);

    @Inject
    CollectionsAdapter adapter;
//    public static CollectionsAdapter adapter = new CollectionsAdapter(CollectionsData.list);

    @Inject
    CollectionsPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LOGGER.log("onCreateView");

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_tab1, container, false);

//        AppInject.getComponent().inject(this); //inject method
        ((AppInject) getActivity().getApplication()).getComponent().inject(this);
        //creating first data
        presenter.createData();

        int numColumns = getContext().getResources().getInteger(R.integer.num_collections_columns);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), numColumns));
        recyclerView.setAdapter(adapter);

        return recyclerView;
    }








    @Override
    public void onCalculationFinished() {
//        Toast.makeText(getActivity(), "Calculation is done", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataIsStillLoadingError() {
//        Toast.makeText(getActivity(), "Calculation is still running!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartCalculation() {
        Activity activity = getActivity();
        LOGGER.log("avtivity " + activity);
        if(activity != null){
        Toast.makeText(getActivity().getApplicationContext(), "Calculation is starting", Toast.LENGTH_SHORT).show();
        }

//        Toast.makeText(getContext(), "Calculation is starting", Toast.LENGTH_SHORT).show();
        getInject();
        presenter.calculate();
    }

    /** from Dima project */

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onStop() {
        presenter.detachView();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }




    /***/




    @Override
    public void onButtonClick() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void updateAdapter() {
        LOGGER.log("updateAdapter");
        getInject();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateItemAdapter(int position) {
        getInject();
        adapter.notifyItemChanged(position);
        LOGGER.log("notifyItemChanged // adapter // " + adapter.toString());
    }

    @Override
    public void showProgressBar(int position){
        LOGGER.log("showProgressBar");
        CollectionsData.list.get(position).setProgressBar(true);
        updateItemAdapter(position);
    }

    @Override
    public void hideProgressBar(int position){
        LOGGER.log("hideProgressBar");
        CollectionsData.list.get(position).setProgressBar(false);
        updateItemAdapter(position);
    }

    void getInject(){
        AppInject.getComponent().inject(this);
    }


    public void allItems(){
        for (int i = 0; i < 3; i++) {
            LOGGER.log(" action " + CollectionsData.list.get(i).getAction()
                    + "\n name " + CollectionsData.list.get(i).getName()
                    + "\n progress bar " + CollectionsData.list.get(i).getProgressBar()
                    + "\n result " + CollectionsData.list.get(i).getResultOfCalculation());
        }
    }

}



