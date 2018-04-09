package com.example.alex.collectionsandmap.collections;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alex.collectionsandmap.R;
import com.example.alex.collectionsandmap.adapters.CollectionsAdapter;
import com.example.alex.collectionsandmap.dagger.AppInject;
import com.example.alex.collectionsandmap.dataCollections.CollectionsData;
import com.example.alex.collectionsandmap.utils.Logger;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class CollectionsFragment extends Fragment implements CollectionsContract.View {

    private static Logger LOGGER = new Logger(CollectionsFragment.class);
    private String TAG = "life";
    public static int INPUT_NUMBER;

    // TODO: 08.04.2018 Don't work without STATIC adapter
//    @Inject
//    CollectionsAdapter adapter;

    public static CollectionsAdapter adapter = new CollectionsAdapter(CollectionsData.list);

    @Inject
    CollectionsPresenter presenter;

    @BindView(R.id.tab1_recycler)
    RecyclerView recyclerView;

    @BindView(R.id.editText_input_fragment)
    EditText interNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LOGGER.log("onCreateView");
        Log.d(TAG, "onCreateView: ");

        View root = inflater.inflate(R.layout.fragment_tab1, container, false);
        ButterKnife.bind(this, root);

        recyclerView = root.findViewById(R.id.tab1_recycler);

        AppInject.getComponent().inject(this); //inject method
        //creating first data
        presenter.createData();

        int numColumns = getContext().getResources().getInteger(R.integer.num_collections_columns);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), numColumns));
        recyclerView.setAdapter(adapter);

        return root;
    }


    @OnClick(R.id.button_calculate)
    public void clickCalculation(){

        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }

        String number = interNumber.getText().toString();
        if (number.length() > 0) {
            INPUT_NUMBER = Integer.parseInt(number);
            onCalculationStarted();
            getInject();
            presenter.calculate();
        } else {
           showErrorEmptyNumber();
        }
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
    public void onCalculationStarted(){
        Log.d(TAG, "onCalculationStarted: ");
        Toast.makeText(getContext(), "Calculation is starting", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartCalculation() {
        Log.d(TAG, "onStartCalculation: " );
        getInject();
        presenter.calculate();
    }

    @Override
    public void onButtonClick() {

    }

    @Override
    public void showErrorEmptyNumber() {
        // TODO: 08.04.2018  If it is called from another class - Context is missing
        Toast.makeText(getContext(), " Введите число", Toast.LENGTH_SHORT).show();
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



    // lifecycle
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + getActivity().toString());
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView: ");
        super.onDestroyView();
    }
}



