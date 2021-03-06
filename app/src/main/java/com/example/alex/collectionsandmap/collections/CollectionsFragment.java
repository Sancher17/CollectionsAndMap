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
import com.example.alex.collectionsandmap.dagger.AppInject;
import com.example.alex.collectionsandmap.utils.Logger;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class CollectionsFragment extends Fragment implements CollectionsContract.View {

    private static Logger LOGGER = new Logger(CollectionsFragment.class);
    private String TAG = "life";
    public static int INPUT_NUMBER;

    @Inject CollectionsAdapter adapter;

    @Inject CollectionsContract.Presenter presenter;

    @BindView(R.id.tab1_recycler)
    RecyclerView recyclerView;

    @BindView(R.id.editText_input_fragment)
    EditText interNumber;

    private View root;

    @Override
    public void attachPresenter(){
        presenter.attachView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LOGGER.log("onCreateView");
        Log.d(TAG, "onCreateView: ");

        root = inflater.inflate(R.layout.fragment_tab1, container, false);

        ButterKnife.bind(this, root);

        recyclerView = root.findViewById(R.id.tab1_recycler);

        AppInject.getComponent().inject(this);

        int numColumns = getContext().getResources().getInteger(R.integer.num_collections_columns);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), numColumns));
        recyclerView.setAdapter(adapter);


        Log.d(TAG, "onCreateView // root 2 "+ root.toString() );
        return root;
    }


    @OnClick(R.id.button_calculate)
    public void clickCalculation(){

        // hide keyboard after inputted number
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity()
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }

        String number = interNumber.getText().toString();
        if (number.length() > 0) {
            INPUT_NUMBER = Integer.parseInt(number);
            presenter.calculate();
        } else {
           showErrorEmptyNumber();
        }
    }

    @OnClick(R.id.button_stop)
    public void clickButtonStop(){
        presenter.stopСalculation();
    }

    @Override
    public void stopAllProgressBars(){
        for (int i = 0; i < 21; i++) {
            adapter.items.get(i).setProgressBar(false);
        }
    }

    @Override
    public void showWait() {
        Toast.makeText(getActivity(), "Wait calculation soon stopped", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showCalculationNotStarted() {
        Toast.makeText(getActivity(), "Calculation is not started", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showCalculationStopped(){
        Toast.makeText(getActivity(), "Calculation is stopped", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showCalculationFinished() {
        Toast.makeText(getActivity(), "Calculation is done", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCalculationIsStillWorking() {
        Toast.makeText(getActivity(), "Calculation is still running!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCalculationStarted(){
        Toast.makeText(getContext(), "Calculation is starting", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorEmptyNumber() {
        Toast.makeText(getContext(), "Enter number", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateAdapter() {
        LOGGER.log("updateAdapter");
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateItemAdapter(int position) {
        adapter.notifyItemChanged(position);
        LOGGER.log("notifyItemChanged // adapter // " + adapter.toString());
    }

    @Override
    public void showProgressBar(int position){
//        LOGGER.log("showProgressBar");
        adapter.items.get(position).setProgressBar(true);
        updateItemAdapter(position);
    }

    @Override
    public void hideProgressBar(int position){
        LOGGER.log("hideProgressBar");
        adapter.items.get(position).setProgressBar(false);
        updateItemAdapter(position);
    }



    // lifecycle
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
        presenter.detachView();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + getActivity().toString());
        attachPresenter();
    }


    // for controlling
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
        super.onStart();
        Log.d(TAG, "onStart: ");
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
//        if (root != null) {
//            ViewGroup parent = (ViewGroup) root.getParent();
//            if (parent != null) {
//                parent.removeAllViews();
//            }
//        }
    }
}



