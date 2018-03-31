package com.example.alex.collectionsandmap.collections;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alex.collectionsandmap.R;
import com.example.alex.collectionsandmap.adapters.CollectionsAdapter;
import com.example.alex.collectionsandmap.dataCollections.CollectionsData;
import com.example.alex.collectionsandmap.utils.Logger;

public class CollectionsFragment extends Fragment implements CollectionsContract.View {

    private static Logger LOGGER = new Logger(CollectionsFragment.class);

    //    public static CollectionsAdapter adapter; //was
    private CollectionsAdapter adapter; // now
    private CollectionsContract.Presenter presenter  = new CollectionsPresenter(this);

    CollectionsData collections = new CollectionsData();

    public CollectionsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        adapter = new CollectionsAdapter(new ArrayList<CollectionsData>());// тут пока не готово //
        adapter = new CollectionsAdapter(CollectionsData.list);
    }

    @Override
    public void onResume() {
        super.onResume();
//        presenter.loadData(); // пока не готово
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LOGGER.log("onCreateView");

        RecyclerView recyclerView = (RecyclerView) inflater.inflate
                (R.layout.fragment_tab1, container, false);


        //creating first data
        presenter.createData();

        int numColumns = getContext().getResources().getInteger(R.integer.num_collections_columns);

        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), numColumns);
        recyclerView.setLayoutManager(layoutManager);

        return recyclerView;
    }


    @Override
    public void setPresenter(CollectionsContract.Presenter presenter) {

    }

    @Override
    public void onCalculationFinished() {
        Toast.makeText(getActivity(), "Calculation is done", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataIsStillLoadingError() {
        Toast.makeText(getActivity(), "Calculation is still running!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onStartCalculation() {
        LOGGER.log("onStartCalculation");
//        Toast.makeText(getContext(), "Calculation is starting", Toast.LENGTH_SHORT).show();
        presenter.doTask();
    }

    @Override
    public void onButtonClick() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void updateAdapter() {
        adapter.notifyDataSetChanged();
    }

//    @Override
//    public void showResult() {
//        adapter.notifyDataSetChanged();
//    }


//    public void onDataSetChanged(List<Cell> list) {
//        LOGGER.log(list.toString());
//        adapter.setData(list);
//    }

//    @Override  // для примера
//    public void setProgressIndicator(final boolean active) {
//
//        if (getView() == null) {
//            return;
//        }
//        final SwipeRefreshLayout srl =
//                (SwipeRefreshLayout) getView().findViewById(R.id.refresh_layout);
//
//        // Make sure setRefreshing() is called after the layout is done with everything else.
//        srl.post(new Runnable() {
//            @Override
//            public void run() {
//                srl.setRefreshing(active);
//            }
//        });
//    }

}



